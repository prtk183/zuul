package com.szuul.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.szuul.exception.HandleException;
import com.szuul.model.Account;
import com.szuul.model.Transaction;
import com.szuul.service.TransactionServiceImpl;
import com.szuul.wrappers.CreateAccountWrapper;
import com.szuul.wrappers.WrapperTransaction;

@Controller
public class TransactionController {
  
  @Autowired
  TransactionServiceImpl transactonServiceImpl;
  
  @Autowired
  Environment environment;
  
  Logger log = Logger.getLogger(TransactionController.class.getName());
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  @PostMapping("/createtransaction")
   public  ResponseEntity<?> createTransaction( @RequestBody WrapperTransaction object) throws HandleException
   {
    log.info("in transaction controller createTransaction");
     Transaction tax = transactonServiceImpl.createTransaction(object);
     if(tax!=null)
     {return new ResponseEntity<Transaction>(tax, HttpStatus.OK);}
     else
     { return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
    }
  
  
  /**
   * @param object
   * @return
   * @throws HandleException
   */
  @GetMapping("/generatetransactionreport/{accountId}")
  public  ResponseEntity<?> generatetransactionreport( @PathVariable Long accountId) throws HandleException
  {  log.info("in transaction controller generatetransactionreport ");
    List<Transaction> tax = transactonServiceImpl.generteTransactionReport(accountId);
     if(tax!=null)
       {return new ResponseEntity<List<Transaction>>(tax, HttpStatus.OK);}
     else
     {       return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
    }
  
}
