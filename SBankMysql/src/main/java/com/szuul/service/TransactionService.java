package com.szuul.service;

import java.util.List;

import com.szuul.exception.HandleException;
import com.szuul.model.Transaction;
import com.szuul.wrappers.WrapperTransaction;

public interface TransactionService {

  /**/
  /**
   * @param obj
   * @return
   * @throws HandleException
   */
  public Transaction createTransaction(WrapperTransaction obj) throws HandleException;
  
  /**/
  /**
   * @param obj
   * @return
   * @throws HandleException
   */
  public List<Transaction> generteTransactionReport(Long obj) throws HandleException;
  
  
  /**
   * @param transactionId
   * @return
   * @throws HandleException
   */
  public Transaction getTransaction(Long transactionId) throws HandleException;

}
