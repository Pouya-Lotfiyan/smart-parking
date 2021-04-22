package com.pouya.smartparking.modules.payments.model;

import com.pouya.smartparking.enums.State;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_rate")
public class PriceRate {

    @Id
    @GeneratedValue
    private  long id;

    @Column(name = "price_per_hour")
    private  double pricePerHour;

    @Column(name = "price_per_day")
    private  double pricePerDay;

    @Column(name = "price_per_month")
    private  double pricePerMonth;



    private State state = State.ACTIVE;

    @CreationTimestamp
    private LocalDateTime createdAt;


    @UpdateTimestamp
    private LocalDateTime modifiedAt;



    public PriceRate() {
    }

    public PriceRate(double pricePerHour, State state) {
        this.pricePerHour = pricePerHour;
        this.state = state;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



}


