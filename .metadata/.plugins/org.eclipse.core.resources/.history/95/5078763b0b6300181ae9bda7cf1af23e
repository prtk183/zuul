/**
 * 
 */
package com.sbank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.model.Customer;
import com.sbank.service.BankServiceImpl;
import com.sbank.service.CustomerServiceImpl;
import com.sbank.service.IAuditService;
import com.sbank.wrappers.WrapperClass;
import com.sbank.wrappers.WrapperUpdateCustomer;

/**
 * @author trainee
 *
 */
@Controller
public class CustomerController {

  @Autowired
  CustomerServiceImpl customerServiceImpl;

  @Autowired
  BankServiceImpl bankServiceImpl;
  
  @Autowired
  IAuditService loadder;
  
  @Autowired
  Environment environment;
  
  Logger Log = Logger.getLogger(CustomerController.class.getName());

  /**
   * 
   * to add a customer wrapper class including customer object and bank id is sent
   * corresponding bank is traced as per its id and banks foreign key is traced back 
   * @param wrapperClass
   * @return
   * @throws HandleException
   */
  @PostMapping(path = "/createcustomer", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> 
  addOneCustomer(@RequestBody WrapperClass wrapperClass) throws HandleException {

    Log.info("calling comtroller create customer");
   
 
    final Customer result = customerServiceImpl.createCustomer(wrapperClass);
    if(result!=null)

    {return new ResponseEntity<Customer>(result, HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_GATEWAY);}
    
  }


  /**
   * finding customers
   * @return
   * @throws HandleException
   */
  @GetMapping("/viewcustomer")
  public ResponseEntity<?> viewCustomer() throws HandleException {
    Log.info("calling controller view  customer");
    final List<Customer> result = customerServiceImpl.getCustomerdetails();
    if(result!=null)
    {return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}

  }
  
  @PostMapping("/updatecustomer")
  public ResponseEntity<?> updateCustomer(@RequestBody WrapperUpdateCustomer object) throws HandleException, CloneNotSupportedException {
    Log.info("calling controller view  customer");
    System.out.println("********************"+object);
    final Customer result = customerServiceImpl.updateCustomer(object);
    if(result!=null)
    {return new ResponseEntity<Customer>(result, HttpStatus.OK);}
    else
    {return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}

  }

}
