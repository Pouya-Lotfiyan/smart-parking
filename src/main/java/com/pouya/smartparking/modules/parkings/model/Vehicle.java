package com.pouya.smartparking.modules.parkings.model;

import com.pouya.smartparking.enums.RideType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="vehicle")
public class Vehicle {


    @Id
    @GeneratedValue
    private long id;



    @Column(unique = true , name = "license_plate")
     private String licensePlate;

    private  String color;

    @Column(name = "owner_phone")
    private String  ownerPhoneNumber;


    @Column(name = "ride_type")
    private RideType rideType;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private  LocalDateTime modifiedAt;


    public Vehicle() {
    }

    public Vehicle(String licensePlate, String color, String ownerPhoneNumber, RideType rideType) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.rideType = rideType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }



    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", color='" + color + '\'' +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", rideType=" + rideType +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
