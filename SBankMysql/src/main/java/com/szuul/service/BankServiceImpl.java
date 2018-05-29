/**
 * 
 */
package com.szuul.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.szuul.controller.BankController;
import com.szuul.dao.BankRepository;
import com.szuul.exception.HandleException;
import com.szuul.model.Bank;
import com.szuul.model.Bank_Denomination;
//import com.szuul.model.RefMoney;
import com.szuul.wrappers.WrapperCreateBank;

/**
 * @author PrateekG
 *
 */
@Service
public class BankServiceImpl  implements BankService {

  /**-----------log --------------*/
  private Logger log = Logger.getLogger(BankServiceImpl.class.getName());
	
  /**---------bankrepository object--------.*/
	@Autowired
	private BankRepository bankrepository;

	/**------------environment object---------------------.*/
	@Autowired
	private Environment environment;
	
	
	
	@Autowired
	private BankDenominationServiceImpl  bankDenominationServiceImpl;
	
	/**/
	/* creating bank with amount which is in parameter
	 * @see com.szuul.service.BankService#createBank(com.szuul.model.Bank)
	 */
	@Override
	public Bank createBank(final WrapperCreateBank object) throws HandleException {
	  
	log.info("in service createBank");
	  Bank bankCustomer=null;
	  final BigDecimal restrict = new BigDecimal(1000);
	  
	  if(object.getAmount()!=null)
	  {
	      if(object.getAmount().compareTo(restrict)==-1)     //validating initial amount it can not be -ve
	      {
	          throw new HandleException(environment.getProperty("101"));
	      } else {
	                Bank bank = new Bank();
	                bank.setAmount(object.getAmount());
	                bankDenominationServiceImpl.initialzeDenomination();
	                bankCustomer = bankrepository.save(bank);
	                return bankCustomer;
	      }
	  } else {
	            throw new HandleException(environment.getProperty("101"));
	  }
	}

	/**/
	/* get all banks in form of list
	 * @see com.szuul.service.BankService#getBankDetails()
	 */	
	@Override
	public List<Bank> getBankDetails() throws HandleException{
	  log.info("in service getBankDetails");
		List<Bank> bankslist = new ArrayList<Bank>();
		bankslist=bankrepository.findAll();
		if(bankslist.size()==0)
		{
		  throw new HandleException(environment.getProperty("100"));
		}
		else {return bankslist;}
}

	/**/
  /* get the bank having particular bankid 
   * @see com.szuul.service.BankService#getBank(java.math.BigDecimal)
   */
  @Override
  public Bank getBank(final Long bankId) throws HandleException {
    log.info("in service getBank");
    if(bankId!=null)
    {
      Optional op;
      Bank bank=null;
      op = bankrepository.findBybankId(bankId);
    
      if(op.isPresent())
      {
        bank = bankrepository.findBybankId(bankId).get(); 
      }
    return bank;
    } else {
      throw new HandleException(environment.getProperty("7777"));
    }
  }

  /**/
  /* update banks data
   * @see com.szuul.service.BankService#updateBank(com.szuul.model.Bank)
   */
  @Override
  public void updateBank(final Bank bank) throws HandleException {
    // TODO Auto-generated method stub
    log.info("in service updateBank");
    if(bank!=null && bank.getAmount()!=null && bank.getBankId()!=null)
    {
      Optional op;
      op = bankrepository.findBybankId(bank.getBankId());
      if(op.isPresent())
      {
        bankrepository.saveAndFlush(bank); 
      } else {
              throw new HandleException(environment.getProperty("111"));
      }
    } else {
      throw new HandleException(environment.getProperty("7777"));

    }
  }

	
	
}
