package com.sbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.dao.AccountRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.dao.TransactionRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Customer;
import com.sbank.model.Transaction;
import com.sbank.wrappers.WrapperTransaction;

@Service
public class TransactionServiceImpl implements TransactionService{

  /**----------accountServiceImpl object--------------.*/
  @Autowired
  private AccountServiceImpl accountServiceImpl;
  
  /**----------------customerServiceImpl object------------------------.*/
  @Autowired
  private CustomerServiceImpl customerServiceImpl;
  
  /**----------------transactionRepository object---------------------.*/
  @Autowired
  private TransactionRepository transactionRepository;
  
  /**--------------------environment object--------------------*/
  @Autowired
  Environment environment;
  
  /**----------------log object------------------.*/
  Logger log = Logger.getLogger(TransactionServiceImpl.class.getName());
  /**/
  /* create transaction
   * @see com.sbank.service.TransactionService#createTransaction(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public Transaction createTransaction(final WrapperTransaction obj) throws HandleException {
    log.info("in trnsaction service createTransaction ");
  if(obj.getAccount()!=null && obj.getAmount()!=null && obj.getCustomerId()!=null)
  {
    if(accountServiceImpl.getAccountDetail(obj.getAccount()).getAccountId().equals(obj.getAccount())) //validating account
    {
         Account account  = accountServiceImpl.getAccountDetail(obj.getAccount());
         
           if(customerServiceImpl.getCustomer(obj.getCustomerId()).getCustomerId().equals(obj.getCustomerId()))   //validating customer
           {
             final Customer customer = customerServiceImpl.getCustomer(obj.getCustomerId());
             
             final String ttype= obj.getTtype();
             Transaction tax= new Transaction();
    
             tax.setAccount(account);     
             tax.setCustomer(customer);
             tax.setTransactionType(ttype);
             tax.setAmount(obj.getAmount());
             System.out.println("in tax ob"+ttype);
             tax=transactionRepository.save(tax); //saving 
             return tax;
   
           } else {
        
             throw new HandleException(environment.getProperty("501"));
           }
    }  else {
      throw new HandleException(environment.getProperty("502"));
    }
  } else {
    throw new HandleException(environment.getProperty("7777"));

  }
  }

  /**/
  /* generating report for an id
   * @see com.sbank.service.TransactionService#generteTransactionReport(com.sbank.wrappers.WrapperTransaction)
   */
  @Override
  public List<Transaction> generteTransactionReport(final Long accountId) throws HandleException {
    log.info("in trnsaction service generteTransactionReport");
 if(accountId!=null)
 {
    List<Transaction> transactionList  = transactionRepository.findAll();
   
    List<Transaction> transactionReportForById= new ArrayList<Transaction>();
    System.out.println(transactionList);
    System.out.println("above loop");
  //  System.out.println("a+"+ts.getAccount().getAccountId());
    System.out.println("b+"+accountId);
    for(Transaction ts :transactionList)
    {
      int i=0;
      if(ts.getAccount().getAccountId().equals(accountId))     //fetching transaction record for an account id
      {
    
        transactionReportForById.add(transactionRepository.findBytransactionId(ts.getTransactionId()).get());
    
      }
      System.out.println("yttreresdf"+i++);
    }
    System.out.println("totalList"+transactionReportForById);
    if(transactionReportForById.isEmpty())
    {
      throw new HandleException(environment.getProperty("500"));
    }
    else
    {
       return transactionReportForById;
    }
 }
 else
 {
   throw new HandleException(environment.getProperty("7777"));

 }
  }

  @Override
  public Transaction getTransaction(final Long transactionId) throws HandleException {
    log.info("in trnsaction service getTransaction");
    if(transactionId!=null)
    {
    Transaction Tax = transactionRepository.findBytransactionId(transactionId).get();
    return Tax;
    
    }
    else
    {
      throw new HandleException(environment.getProperty("7777"));

    }
  }


}
