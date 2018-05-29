 package com.sbank.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.controller.CustomerController;
import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Audit;
import com.sbank.model.Bank;
import com.sbank.model.Customer;
import com.sbank.model.EnumClass;
import com.sbank.wrappers.WrapperClass;
import com.sbank.wrappers.WrapperUpdateCustomer;



@Service
public class CustomerServiceImpl implements CustomerService {

  /**------------customerRepository object-----------------.*/
	@Autowired
	private CustomerRepository customerRepository;
	
	/**----------Log---------------.*/
  Logger Log = Logger.getLogger(CustomerServiceImpl.class.getName());
  
  /**------------environment-----------------.*/
  @Autowired
  private Environment environment;
  
	/**----------------bankServiceImpl--------------------------.*/ 
  @Autowired
	 private BankServiceImpl bankServiceImpl;
  
  /**------------------audit service impl object-----------------------.*/
  @Autowired
  private IAuditService auditService;
  
	/**/
	/* crating customer with id, pi, name and bankid
	 * @see com.sbank.service.CustomerService#createCustomer(com.sbank.model.Customer)
	 */
	@SuppressWarnings("unlikely-arg-type")
  @Override
	public Customer createCustomer(WrapperClass wrapperClass) throws HandleException {
	  
	 
	  Log.info("in customer service calling createCustomer");
	  
	  if(wrapperClass!=null && wrapperClass.getBankId()!=null && wrapperClass.customer!=null )
	  {
	    
	  if(( bankServiceImpl.getBank(wrapperClass.getBankId()).getBankId()
	      .equals(wrapperClass.getBankId()) )) //cheking valid bank in argument 
	    {
	        if( wrapperClass.customer.getCustomerName().isEmpty()
	            && wrapperClass.customer.getPin()==null )  //checking valid customer data
	          {
	              throw new HandleException(environment.getProperty("201"));
	          } else {
	            Customer addNewCustomer = new Customer(wrapperClass.customer.getCustomerName(),  wrapperClass.customer.getPin(), bankServiceImpl.getBank(wrapperClass.getBankId()));
	                      addNewCustomer =  customerRepository.save(addNewCustomer);
	                      return addNewCustomer;
	         }
	    } else {
	      throw new HandleException(environment.getProperty("202")); 
	    }
	  } else {
      throw new HandleException(environment.getProperty("7777")); 

	  }
	}



	/*
   * showing customers
   * 
	 * @see com.sbank.service.CustomerService#getCustomerdetails()
	 */
	@Override
	public List<Customer> getCustomerdetails() throws HandleException {
		
	  Log.info("in customer service calling getCustomerdetails");
		List<Customer> custlist;
		
		custlist=customerRepository.findAll();
		
		if(custlist.size()==0)
		{
		  throw new HandleException(environment.getProperty("200"));
		}
		else
		{
		  return custlist;
		}
	}


	/**/
  /* get customer by id
   * @see com.sbank.service.CustomerService#getCustomer(java.lang.Long)
   */
  @Override
  public Customer getCustomer(final Long customerId) throws HandleException {
    Log.info("in customer service calling getCustomer");
    Optional op;
    Customer customer=null;
    
    op= customerRepository.findBycustomerId(customerId);
    if(op.isPresent())
    {
        customer = customerRepository.findBycustomerId(customerId).get();
        return customer;
    }
    else
    {
      throw new HandleException(environment.getProperty("200"));
    }
    
   
  }



  @Override
  public Customer updateCustomer(final WrapperUpdateCustomer object) throws HandleException, CloneNotSupportedException {
    Log.info("in customer service calling updateCustomer");

    if( object.getCustomerBankId()!=null & object.getCustomerName()!=null)
    {
      
      final Customer customer = customerRepository.findBycustomerId(object.getId()).get();
      
      Log.info("in customer service bindig audit");
      customer.setBank(bankServiceImpl.getBank(object.getCustomerBankId()));
 
      final Audit audit = new Audit();
      Timestamp time= Timestamp.valueOf(LocalDateTime.now()) ;
      audit.setEventDate(time);
      //audit.setEventId(UUID.randomUUID());
      audit.setEventName(EnumClass.eventName.CUSTOMER.toString());
      audit.setEventType(EnumClass.eventType.UPDATED.toString());
     
      Customer clonedCustomer = (Customer) customer.clone();
      
      audit.setOldValue(clonedCustomer);
      customer.setCustomerName(object.getCustomerName());
      Customer newValue = customerRepository.save(customer);
      audit.setNewValue(newValue);

      auditService.sendAuditToMongo(audit); //sending audit reposrt via service
   
      return newValue;
    }
    else
    {
      throw new HandleException(environment.getProperty("7777"));
    }
  }
		

}
