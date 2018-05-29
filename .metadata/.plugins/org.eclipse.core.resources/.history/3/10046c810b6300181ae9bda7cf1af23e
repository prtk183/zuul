
package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Bank Entity.
 * @author trainee
 *
 */

@Entity
@Table(name = "BANK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank {



  /**-----bank id as primary key-------*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "bank_Id")  Long bankId;
  
  /**-----inital amount to create bank -------*/
  @Column(name = "amount")
  private BigDecimal amount;
  
  /**
   * 
   * consutructor
   */

  public Bank(final BigDecimal amount) {
    this.amount = amount;
  }

  public Long getBankId() {
    return bankId;
  }

  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

 

  /*
   * @return the amount
   */
  public BigDecimal getAmount() {
    return amount;
  }

  /**
   * @param amount
   *          the amount to set
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Bank() {
  }

  
  
  public Bank(Long bankId, BigDecimal amount) {
    super();
    this.bankId = bankId;
    this.amount = amount;
  }

  /*
   * 
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
  }

}
