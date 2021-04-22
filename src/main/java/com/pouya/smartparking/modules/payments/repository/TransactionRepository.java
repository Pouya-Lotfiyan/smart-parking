package com.pouya.smartparking.modules.payments.repository;

import com.pouya.smartparking.modules.payments.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
