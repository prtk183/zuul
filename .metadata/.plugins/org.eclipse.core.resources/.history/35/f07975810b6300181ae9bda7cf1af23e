package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sbank.model.Bank;

@Entity
@Table(name="ATM")
public class ATM {
  
  /**------------*/
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long atmId;
  /**------------*/
  private BigDecimal amount;

  
  @ManyToOne(targetEntity=Bank.class)
  /**------------*/
  private Bank bank;

  

  public Long getAtmId() {
    return atmId;
  }

  public void setAtmId(Long atmId) {
    this.atmId = atmId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  
  
  
}
