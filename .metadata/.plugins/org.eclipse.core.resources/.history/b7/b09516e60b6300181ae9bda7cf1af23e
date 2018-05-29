package com.sbank.wrappers;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WrapperCreateBank {
  
  public WrapperCreateBank()
  {
    
  }

  
  
public WrapperCreateBank(Integer amount) {
    super();
    this.amount = new BigDecimal(amount);
  }



/**---amount----*/
  BigDecimal amount;


  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


 
}
