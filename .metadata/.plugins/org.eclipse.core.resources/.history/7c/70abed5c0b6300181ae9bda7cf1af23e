/**
 * 
 */
package com.sbank.dao;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbank.model.Bank;

/**
 * @author trainee
 *
 */
public interface BankRepository extends JpaRepository<Bank, Long> {

	
  @Query
  Optional<Bank> findBybankId(Long bankId);
	
	
}
