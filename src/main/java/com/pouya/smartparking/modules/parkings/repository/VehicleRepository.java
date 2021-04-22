package com.pouya.smartparking.modules.parkings.repository;

import com.pouya.smartparking.modules.parkings.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  VehicleRepository extends JpaRepository<Vehicle, Long> {


     public Vehicle findByLicensePlate(String licensePlate);

     public   Vehicle findById(long id);


     @Query(value = "select v from Vehicle v join Parking p on v.id = p.vehicle.id where v.licensePlate = :licensePlate ")
     List<Vehicle> getVehicleHistory(@Param("licensePlate") String licensePlate);


}
