package com.pouya.smartparking.modules.parkings.controller;


import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import com.pouya.smartparking.modules.parkings.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {


    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }



    @GetMapping("")
    public List<Vehicle> findAll(){
        return  this.vehicleService.findAll();
    }

    @PostMapping("")
    public  Vehicle insert(@RequestBody Vehicle vehicle){
        return this.vehicleService.insert(vehicle);
    }


    @GetMapping("/{licensePlate}")
    public  List<Parking> getVehicleHistory(@PathVariable("licensePlate") String licensePlate,
                                            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime from,
                                            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime to                                            ){

        return this.vehicleService.getVehicleHistory(licensePlate, from , to);
    }


}
