package com.szuul.wrappers;

import java.math.BigDecimal;

public class CreateAccountWrapper {
 
  /**bankId */
  private Long bankId;
  /**------------*/
  private Long customerId;
  /**------------*/
  private BigDecimal amount;
  
  public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
  @Override
  public String toString() {
    return "CreateAccountWrapper [bankId=" + bankId + ", customerId=" + customerId + ", amount="
        + amount + "]";
  }
  public Long getCustomerId() {
    return customerId;
  }
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  
  public CreateAccountWrapper()
  {
    
  }
  public CreateAccountWrapper(Long bankId, Long customerId, Integer amount) {
    super();
    this.bankId = bankId;
    this.customerId = customerId;
    this.amount = new BigDecimal(amount);
  }
 


}
