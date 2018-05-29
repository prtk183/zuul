package com.sbank.service;

import org.springframework.stereotype.Service;

import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;
@Service
public interface ATMService {

  /**/
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public ATM createATM(WrapperATMCreate object) throws HandleException;
  
  /**/
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public ATM addMoneyFromBank(WrapperATMAddMoneyToATM object) throws HandleException;
  
  /**/
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public ATM withdrawMoney(WrapperATMWithdraw object) throws HandleException;
  
  /**/
  /**
   * @param atmId
   * @return
   */
  public ATM getAtm(Long atmId) throws HandleException;
}
