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

@Entity(name="Atm_Denomination")
public class Atm_Denomination {

  /**------------*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long atmDenominationId;
  
  /**-----------------------.*/
  private Integer currency;
  
  /**---------------------------.*/
  private Integer count;
  
  public Atm_Denomination()
  {
    
  }

  public Atm_Denomination(Integer currency, Integer count) {
    super();
    this.currency = currency;
    this.count = count;
  }

  public Long getAtmDenominationId() {
    return atmDenominationId;
  }

  public void setAtmDenominationId(Long atmDenominationId) {
    this.atmDenominationId = atmDenominationId;
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