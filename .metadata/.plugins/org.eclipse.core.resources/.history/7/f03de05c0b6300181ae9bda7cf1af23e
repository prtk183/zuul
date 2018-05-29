package com.sbank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbank.model.Customer;
import com.sbank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  @Query
  Optional<Transaction> findBytransactionId(Long transactionId);

  
}
