/**
 * 
 */
package com.szuul.wrappers;

import com.szuul.model.Customer;
import com.szuul.model.Bank;

/**
 * @author trainee
 *
 */
public class WrapperClass {
 /**--------bankId-----*/
  public Long bankId;
  /**-----customer--------*/
  public Customer customer;
  
	public Long getBankId() {
    return bankId;
  }
  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }
 
	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
