package com.pouya.smartparking.modules.payments.service;


import com.pouya.smartparking.enums.TransactionStatus;
import com.pouya.smartparking.modules.parkings.model.Parking;
import com.pouya.smartparking.modules.payments.model.Transaction;
import com.pouya.smartparking.modules.payments.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private ApplicationContext context;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ApplicationContext context) {
        this.transactionRepository = transactionRepository;
        this.context = context;
    }

    public List<Transaction> findAll() {
        return  this.transactionRepository.findAll();
    }

    public Transaction insert(Transaction transaction) {

        return this.transactionRepository.save(transaction);


    }


    public Transaction pay(Parking parking) {
        Transaction transaction = this.context.getBean(Transaction.class);
        transaction.setParking(parking);
        transaction.setPaidTme(LocalDateTime.now());
        transaction.setFinalPrice(parking.getTotalPrice());
        Random random = new Random();
        boolean paid = random.nextBoolean();
        if(paid){
            transaction.setStatus(TransactionStatus.SUCCESS);
        }else  {
            transaction.setStatus(TransactionStatus.FAILD);
        }

        return  this.insert(transaction);


    }





}
