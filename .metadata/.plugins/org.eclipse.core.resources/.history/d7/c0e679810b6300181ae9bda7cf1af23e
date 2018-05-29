package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {

  /**------------*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long accountId;
  
  //private Integer customerId;
  /**------------*/
  private BigDecimal amount;
  /**------------*/
  @ManyToOne(targetEntity=Bank.class)
  private Bank bank;
  
  
  /**------------*/
  @OneToOne
  @JoinColumn(name = "customerId", nullable = false)
  Customer customer;
  
  
  
  public Account(Long accountId, BigDecimal amount, Bank bank, Customer customer) {
    super();
    this.accountId = accountId;
    this.amount = amount;
    this.bank = bank;
    this.customer = customer;
  }

  public Account() {
    // TODO Auto-generated constructor stub
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }


  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Account [accountId=" + accountId + ", amount=" + amount + ", bank=" + bank
        + ", customer=" + customer + "]";
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  
}
