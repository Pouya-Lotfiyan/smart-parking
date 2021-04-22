package com.pouya.smartparking.modules.payments.controller;

import com.pouya.smartparking.modules.payments.model.PriceRate;
import com.pouya.smartparking.modules.payments.repository.PriceRateRepository;
import com.pouya.smartparking.modules.payments.service.PriceRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price_rates")
public class PriceRateController {

    private PriceRateService priceRateService;

    @Autowired
    public PriceRateController(PriceRateService priceRateService) {
        this.priceRateService = priceRateService;
    }

    @GetMapping
    public List<PriceRate> findAll(){
        return  this.priceRateService.findAll();
    }


    @PostMapping
    public PriceRate insert(@RequestBody PriceRate priceRate){
        return  this.priceRateService.insert(priceRate);
    }


}
