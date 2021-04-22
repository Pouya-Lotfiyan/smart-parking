package com.pouya.smartparking.modules.payments.controller;

import com.pouya.smartparking.enums.TransactionStatus;
import com.pouya.smartparking.modules.payments.model.Transaction;
import com.pouya.smartparking.modules.payments.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactins")
public class TransactionController {


    private TransactionService  transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("")
    public List<Transaction> findAll(){
        return this.transactionService.findAll();
    }

    @PostMapping("")
    public Transaction insert(@RequestBody Transaction transaction ) {
        return this.transactionService.insert(transaction);
    }








}
