package com.sbank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbank.model.ATM;

public interface ATMRepository extends JpaRepository<ATM, Long>{
  @Query
  Optional<ATM> findByatmId(Long atmId);
}
