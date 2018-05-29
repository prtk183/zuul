package com.sbank.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.service.AccountServiceImpl;
import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;

/**
 * @author Prateek
 *
 */
@Controller
public class AccountController {

  Logger log = Logger.getLogger(AccountController.class.getName());
  /**------------*/
  @Autowired
  AccountServiceImpl accountServiceImpl;
  
  @Autowired
  Environment environment;

  /*
   * calling createAccount taking wrapper object containig customerid, account id and amount
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/createaccount")
  public ResponseEntity<?> callcreateAccount(@RequestBody  CreateAccountWrapper object)
      throws HandleException {
    log.info("in calling create account from controller");

    final Account act = accountServiceImpl.createAccount(object);
    if(act!=null)
    {
      return new ResponseEntity<Account>(act, HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);
    }

  }

  /*
   * calling get account service
   * 
   * @return
   * @throws HandleException
   */
  @GetMapping("/getaccounts")
  public ResponseEntity<?> callgetAccountDetails() throws HandleException {
    log.info(" calling get account details from controller");
    final List<Account> accountList = accountServiceImpl.getAccountDetails();
    if(accountList!=null)
    { return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);}
    else
    { return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}


  }


  /*calling deposit service
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/depositemoney")      
  public ResponseEntity<?> depositeMoney(@RequestBody final WrapperAccountDeposite object)
      throws HandleException {
    log.info(" calling depositeMoney from controller");
    final Account act = accountServiceImpl.depositeMoney(object);
    if(act!=null)
    {return new ResponseEntity<Account>(act, HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}

  }

  /*
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/withdrawmoneyfromaccount")
  public ResponseEntity<?> withdrawMoney(@RequestBody final WrapperAccountDeposite object)
      throws HandleException {
    log.info(" calling withdraw amount from controller");
    final Account act = accountServiceImpl.withdrawMoney(object);

    if(act!=null)
    {return new ResponseEntity<Account>(act, HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
  }

}
