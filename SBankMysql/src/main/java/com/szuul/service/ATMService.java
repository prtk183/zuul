package com.szuul.service;

import org.springframework.stereotype.Service;

import com.szuul.exception.HandleException;
import com.szuul.model.ATM;
import com.szuul.wrappers.WrapperATMAddMoneyToATM;
import com.szuul.wrappers.WrapperATMCreate;
import com.szuul.wrappers.WrapperATMWithdraw;
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
