package com.pouya.smartparking.modules.parkings.controller;

import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import com.pouya.smartparking.modules.parkings.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableScheduling
@RestController
@RequestMapping("/parkings")
public class ParkingController {


    private ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService){
        this.parkingService = parkingService;
    }



    @GetMapping("")
    public List<Parking> findAll(){
        return  this.parkingService.findAll();
    }


    @PostMapping("/enter")
    public Parking insert(@RequestBody Vehicle vehicle){
        return  this.parkingService.enter(vehicle);
    }

    @Scheduled(fixedRate = 5000)
    @GetMapping(value="/enter/scheduled")
    public List<Parking> scheduledInsert() {
        return  this.parkingService.scheduledInsert(3);
    }


    @PostMapping("/exit")
    public ResponseEntity<Parking> exit(@RequestBody Vehicle vehicle){
            Parking parking = this.parkingService.exit(vehicle);
            if(parking != null){
                return new ResponseEntity<>(parking, HttpStatus.OK) ;

            }
            else {
                return new ResponseEntity<>(parking, HttpStatus.BAD_REQUEST) ;

            }
    }


}
