package com.sbank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
  
  /**------transactionId----.**/
  @Id
  @Column(name = "transacId", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  
  private Long transactionId;
  /**-----customer-----.*/
  
  @ManyToOne(targetEntity = Customer.class)
  private Customer customer;
  
  /**----account------.*/
  @ManyToOne(targetEntity = Account.class)
  private Account account;
  
  /**-----amount-----.*/
  private BigDecimal amount;
  
  /**-----transactionType-----.*/
  private String transactionType;
  
  /**----toString--.*/
  @Override
  public String toString() {
    return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", account="
        + account + ", amount=" + amount + ", transactionType=" + transactionType + "]";
  }


  /**
   * default constructor.
   */
  public Transaction()
  {
    
  }
  
  /**.
   * @return.
   */
  public Long getTransactionId() {
    return transactionId;
  }
  
  /**.
   * @param transactionId.
   */
  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

 
  /**.
   * @return.
   */
  public Customer getCustomer() {
    return customer;
  }
 
  /**.
   * @param customer.
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
  /**.
   * @return.
   */
  public Account getAccount() {
    return account;
  }

  /**.
   * @param account.
   */
  public void setAccount(Account account) {
    this.account = account;
  }
  
  /**.
   * @return.
   */
  public BigDecimal getAmount() {
    return amount;
  }
 
  /**.
   * @param amount.
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
 
  /**.
   * @return.
   */
  public String getTransactionType() {
    return transactionType;
  }
  
  /**.
   * @param transactionType.
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }


}
