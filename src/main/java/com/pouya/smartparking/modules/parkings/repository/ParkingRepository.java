package com.pouya.smartparking.modules.parkings.repository;

import com.pouya.smartparking.enums.PaymentStatus;
import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    List<Parking> findByVehicle(Vehicle vehicle);

    Parking findByVehicleAndStatus(Vehicle vehicle , PaymentStatus status);

    Parking findById(long id);

    List<Parking> findByVehicleAndEntranceTimeBetween(Vehicle vehicle , LocalDateTime from , LocalDateTime to);



}
