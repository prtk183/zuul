/**
 * 
 */
package com.szuul.service;

import java.math.BigDecimal;
import java.util.List;

import com.szuul.exception.HandleException;
import com.szuul.model.Bank;
//import com.szuul.model.RefMoney;
import com.szuul.wrappers.WrapperCreateBank;

/**
 * @author trainee
 *
 */
public interface BankService  {

	/**/
  /**
   * @param bank
   * @return bank
   * @throws HandleException
   */
  Bank createBank(WrapperCreateBank object) throws HandleException ;
  

	/**
	 * @return list of banks
	 * @throws HandleException
	 */
	List<Bank> getBankDetails( ) throws HandleException;

	/**
	 * @param bankId
	 * @return bank
	 * @throws HandleException
	 */
	Bank getBank(Long bankId) throws HandleException;
	/**/
	/**
	 * @param bank
	 * @throws HandleException
	 */
	void updateBank(Bank bank) throws HandleException;
}
