package com.sbank.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Bank_Denomination {
  
  /**------------*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long bankdenominationref;
  
  /**--------available currency with bank---------.*/
 private Integer currency;
 
 /**---------count of currency------------.*/
 private Integer count;
 
 Bank_Denomination()
 {
   
 }
 
  @Override
public String toString() {
  return "Bank_Denomination [bankdenominationref=" + bankdenominationref + ", currency=" + currency
      + ", count=" + count + "]";
}

  public Bank_Denomination(Integer currency, Integer count) {
  super();
  this.currency = currency;
  this.count = count;
}

  public Integer getCurrency() {
    return currency;
  }

  public void setCurrency(Integer currency) {
    this.currency = currency;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

 
 
 
 
 
}
