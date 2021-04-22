package com.pouya.smartparking.modules.payments.repository;

import com.pouya.smartparking.enums.PaymentStatus;
import com.pouya.smartparking.enums.State;
import com.pouya.smartparking.modules.payments.model.PriceRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PriceRateRepository extends JpaRepository<PriceRate, Long> {


    @Transactional
    @Modifying
    @Query(value = "update PriceRate pr set pr.state = :toStatus where pr.state = :whereStatus")
    int updateStatus(@Param("whereStatus") State whereStatus,  @Param("toStatus") State toStatus);


    PriceRate findByState(State state);


}
