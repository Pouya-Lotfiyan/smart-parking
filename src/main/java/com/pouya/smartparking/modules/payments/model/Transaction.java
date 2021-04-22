package com.pouya.smartparking.modules.payments.model;

import com.pouya.smartparking.enums.TransactionStatus;
import com.pouya.smartparking.modules.parkings.model.Parking;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private  long id;

    private TransactionStatus status;

    @ManyToOne
    private Parking parking;

    @Column(name = "final_price")
    private double finalPrice;


    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "paid_time")
    private LocalDateTime paidTme;



    public Transaction() {
    }

    public Transaction(long id, TransactionStatus status, Parking parking, double finalPrice) {
        this.id = id;
        this.status = status;
        this.parking = parking;
        this.finalPrice = finalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getPaidTme() {
        return paidTme;
    }

    public void setPaidTme(LocalDateTime paidTme) {
        this.paidTme = paidTme;
    }


}
