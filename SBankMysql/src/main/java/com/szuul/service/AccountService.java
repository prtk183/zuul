package com.szuul.service;

import java.util.List;
import java.util.logging.Logger;

import com.szuul.exception.HandleException;
import com.szuul.model.Account;
import com.szuul.wrappers.CreateAccountWrapper;
import com.szuul.wrappers.WrapperAccountDeposite;

public interface AccountService {
  

 
  @SuppressWarnings("PMD.CommentRequired")
  Logger log = Logger.getLogger(AccountService.class.getName()); //logging
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account createAccount(CreateAccountWrapper object) throws HandleException;


  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account depositeMoney(WrapperAccountDeposite object) throws HandleException;
 
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  public Account withdrawMoney(WrapperAccountDeposite object) throws HandleException;
  

  /**
   * @return
   * @throws HandleException
   */
  public List<Account> getAccountDetails() throws HandleException;
  

  /**
   * @param Id
   * @return
   * @throws HandleException
   */
  public Account getAccountDetail(Long Id) throws HandleException;
  
  /**/
  /**
   * @param account
   * @throws HandleException
   */
  public void updateAccount(Account account) throws HandleException;
 

}
