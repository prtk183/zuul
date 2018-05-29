/**
 * 
 */
package com.sbank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbank.model.Customer;

/**
 * @author trainee
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
  /** findbycustomerId method .
   * @param customerId
   * @return
   */
  @Query
  Optional<Customer> findBycustomerId(Long customerId);
}
