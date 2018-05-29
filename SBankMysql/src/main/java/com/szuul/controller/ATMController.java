package com.szuul.controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szuul.dao.ATMRepository;
import com.szuul.dao.AccountRepository;
import com.szuul.dao.BankRepository;
import com.szuul.exception.HandleException;
import com.szuul.model.ATM;
import com.szuul.model.Account;
import com.szuul.model.Bank;
import com.szuul.service.ATMService;
import com.szuul.wrappers.WrapperATMAddMoneyToATM;
import com.szuul.wrappers.WrapperATMCreate;
import com.szuul.wrappers.WrapperATMWithdraw;

@Controller
public class ATMController {

 
 
  @Autowired
  com.szuul.service.ATMServiceImpl ATMServiceImpl;
  
  @Autowired
  Environment environment;

  Logger log = Logger.getLogger(ATMController.class.getName());
  /**
   * this will call create atm in service
   * with arguments as bankid and its own details
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/createatm")
  public ResponseEntity<?> callcreateATM(@RequestBody WrapperATMCreate object) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller creating atm");
 
    atm = ATMServiceImpl.createATM(object);
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }

  /**to add money from bank
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/addmoneyfrombank")
  public ResponseEntity<?> calladdMoneyFromBank(@RequestBody WrapperATMAddMoneyToATM object) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller calladdMoneyFromBank");
    atm = ATMServiceImpl.addMoneyFromBank(object);
 
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }

  /**
   * call withdraw service
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/withdrawmoney")
  public ResponseEntity<?> callwithdrawMoney(@RequestBody WrapperATMWithdraw object) throws HandleException
  {
    ATM atm = new ATM();
    log.info("in controller callwithdrawMoney");
    atm = ATMServiceImpl.withdrawMoney(object);
    if(atm!=null)
    {return new ResponseEntity<ATM>(atm,HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"),HttpStatus.BAD_REQUEST);}
  }
}
