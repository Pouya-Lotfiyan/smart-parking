package com.pouya.smartparking.modules.payments.service;

import com.pouya.smartparking.enums.State;
import com.pouya.smartparking.modules.payments.model.PriceRate;
import com.pouya.smartparking.modules.payments.repository.PriceRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceRateService {

    private PriceRateRepository priceRateRepository;

    @Autowired
    public PriceRateService(PriceRateRepository priceRateRepository) {
        this.priceRateRepository = priceRateRepository;
    }

    public List<PriceRate> findAll(){
        return this.priceRateRepository.findAll();
    }

    public  PriceRate insert(PriceRate priceRate){
        this.deactiveLast();
        return  this.priceRateRepository.save(priceRate);
    }

    public int deactiveLast(){
        return  this.priceRateRepository.updateStatus(State.ACTIVE ,State.DEACTIVE);
    }


}
