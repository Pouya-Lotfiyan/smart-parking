package com.pouya.smartparking.modules.parkings.model;

import com.pouya.smartparking.enums.PaymentStatus;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Vehicle vehicle;

    @CreationTimestamp
    @Column(name = "entrance_time")
    private LocalDateTime entranceTime;

    @UpdateTimestamp
    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    private PaymentStatus status = PaymentStatus.PENDING;

    @Column(name = "price_rate")
    private  double priceRate;



    @Column(name = "total_price")
    private double totalPrice;


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public double getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", entranceTime=" + entranceTime +
                ", modifiedTime=" + modifiedTime +
                ", exitTime=" + exitTime +
                ", status=" + status +
                ", priceRate=" + priceRate +
                '}';
    }
}
