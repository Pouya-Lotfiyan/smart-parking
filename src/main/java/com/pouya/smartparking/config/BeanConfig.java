package com.pouya.smartparking.config;

import com.github.javafaker.Faker;
import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.parkings.model.Vehicle;
import com.pouya.smartparking.modules.payments.model.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {


    @Bean
    @Scope("prototype")
    public Parking parking(){
        return  new Parking();
    }


    @Bean
    @Scope("prototype")
    public Vehicle vehicle(){
        return  new Vehicle();
    }

    @Bean
    public Faker faker(){
        return  new Faker();
    }

    @Bean("prototype")
    public Transaction transaction(){
        return  new Transaction();
    }

}
