package com.szuul.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.szuul.model.Customer;
import com.szuul.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  @Query
  Optional<Transaction> findBytransactionId(Long transactionId);

  
}
