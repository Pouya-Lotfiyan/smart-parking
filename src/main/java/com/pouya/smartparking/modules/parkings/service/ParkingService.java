package com.pouya.smartparking.modules.parkings.service;

import com.github.javafaker.Faker;
import com.pouya.smartparking.enums.PaymentStatus;
import com.pouya.smartparking.enums.State;
import com.pouya.smartparking.enums.TransactionStatus;
import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import com.pouya.smartparking.modules.parkings.repository.ParkingRepository;
import com.pouya.smartparking.modules.payments.model.PriceRate;
import com.pouya.smartparking.modules.payments.model.Transaction;
import com.pouya.smartparking.modules.payments.repository.PriceRateRepository;
import com.pouya.smartparking.modules.payments.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {

    private ParkingRepository parkingRepository;
    private VehicleService vehicleService;
    private PriceRateRepository priceRateRepository;
    private TransactionService transactionService;
    private Faker faker;
    @Autowired
    private ApplicationContext context;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository,
                          VehicleService vehicleService,
                          PriceRateRepository priceRateRepository,
                          TransactionService transactionService

    ){
        this.parkingRepository = parkingRepository;
        this.vehicleService = vehicleService;
        this.priceRateRepository = priceRateRepository;
        this.transactionService = transactionService;
    }


    public List<Parking> findAll(){
        return this.parkingRepository.findAll();
    }


    public List<Parking> findAllByVehicle(Vehicle vehicle){
        return  this.parkingRepository.findByVehicle(vehicle);
    }

    public Parking enter(Vehicle v){
            Parking parking =  this.context.getBean(Parking.class);
            Vehicle vehicle = this.vehicleService.findOrCreate(v);
            PriceRate priceRate = this.priceRateRepository.findByState(State.ACTIVE);
            parking.setVehicle(vehicle);
            parking.setPriceRate(priceRate.getPricePerHour());
            return   this.parkingRepository.save(parking);

    }

    public  Parking exit(Vehicle v){

        Vehicle vehicle = this.vehicleService.findByLicensePlate(v.getLicensePlate());
        Parking parking;

        if(vehicle != null ){
            parking = this.parkingRepository.findByVehicleAndStatus(vehicle, PaymentStatus.PENDING);
            if(parking != null) {
                parking.setExitTime(LocalDateTime.now());
                double totalPrice = this.calculateTotalPrice(parking);
                parking.setTotalPrice(totalPrice);
                Transaction transaction = this.transactionService.pay(parking);
                if(transaction.getStatus().equals(TransactionStatus.SUCCESS)){
                    parking.setStatus(PaymentStatus.PAID);
                }
                return this.parkingRepository.save(parking);
            }


        }

        return  null;


    }

    private double calculateTotalPrice(Parking parking) {

        Duration distance = Duration.between(parking.getEntranceTime(), parking.getExitTime());
        long hours =  distance.toHours();
        return parking.getPriceRate() * hours;
    }

    public List<Parking> scheduledInsert(int count) {
        Parking parking;
        Vehicle vehicle;
        ArrayList<Parking> parkings = new ArrayList<>();
        this.faker = context.getBean(Faker.class);
        for (int i = 0; i < count ; i++) {
             vehicle = context.getBean(Vehicle.class);
             vehicle.setColor(faker.color().name());
             vehicle.setLicensePlate( String.valueOf(faker.number().numberBetween(10000, 99999)));
             vehicle.setOwnerPhoneNumber(faker.phoneNumber().phoneNumber());
             parking = this.enter(vehicle);
             parkings.add(parking);
        }
        return parkings;

    }
}
