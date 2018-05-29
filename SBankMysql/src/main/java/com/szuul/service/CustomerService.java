/**
 * 
 */
package com.szuul.service;

import java.util.List;

import com.szuul.exception.HandleException;
import com.szuul.model.Customer;
import com.szuul.wrappers.WrapperClass;
import com.szuul.wrappers.WrapperUpdateCustomer;

/**
 * @author trainee
 *
 */
public interface CustomerService {


  /**
   * @param customer
   * @return customer
   * @throws HandleException
   */
  Customer createCustomer(WrapperClass customer) throws HandleException;
	
  
	/**
	 * @return list of customer
	 * @throws HandleException
	 */
	List<Customer> getCustomerdetails() throws HandleException;
	
	
	/**
	 * @param customerId
	 * @return customer
	 * @throws HandleException
	 */
	Customer getCustomer(Long customerId) throws HandleException;
	
	
	/**
	 * @param object
	 * @return
	 * @throws HandleException
	 * @throws CloneNotSupportedException 
	 */
	Customer updateCustomer(WrapperUpdateCustomer object) throws HandleException, CloneNotSupportedException;
}
