package com.szuul.wrappers;

import java.math.BigDecimal;





public class WrapperATMCreate {
  /**--------*/
  private BigDecimal amount;
  /**--------*/
  private Long bankId;
  
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  
}
