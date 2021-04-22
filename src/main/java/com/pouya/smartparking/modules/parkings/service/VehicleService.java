package com.pouya.smartparking.modules.parkings.service;

import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import com.pouya.smartparking.modules.parkings.repository.ParkingRepository;
import com.pouya.smartparking.modules.parkings.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleService {


    private VehicleRepository vehicleRepository;
    private ParkingRepository parkingRepository;

    @Autowired
    public  VehicleService(VehicleRepository vehicleRepository , ParkingRepository parkingRepository){
        this.vehicleRepository = vehicleRepository;
        this.parkingRepository = parkingRepository;
    }


    public List<Vehicle> findAll(){
        return  this.vehicleRepository.findAll();
    }

    public Vehicle insert(Vehicle vehicle){
        return  this.vehicleRepository.save(vehicle);
    }


    public  Vehicle findByLicensePlate(String licensePlate){
        return  this.vehicleRepository.findByLicensePlate(licensePlate);
    }

    public Vehicle findOrCreate(Vehicle vehicle){

        Vehicle foundVehicle = this.vehicleRepository.findByLicensePlate(vehicle.getLicensePlate());

        if(foundVehicle != null){
            return  foundVehicle;
        }

        return this.insert(vehicle);


    }


    public List<Parking> getVehicleHistory(String licensePlate, LocalDateTime from , LocalDateTime to) {
        Vehicle vehicle = this.findByLicensePlate(licensePlate);
        if(from == null || to == null){
            return  this.parkingRepository.findByVehicle(vehicle);
        }

        return  this.parkingRepository.findByVehicleAndEntranceTimeBetween(vehicle, from , to);
    }



}
