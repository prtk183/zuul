/**
 * 
 */
package com.sbank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.service.BankServiceImpl;
import com.sbank.wrappers.WrapperCreateBank;

/**
 * @author trainee
 *
 */
@Controller
public class BankController {

	/**------------bank service object----------.*/
	@Autowired
	BankServiceImpl bankServiceImpl;
	
	/**------environment varaible to access appliaction property---.*/
	@Autowired
  Environment environment;
	
	public BankServiceImpl getBankServiceImpl() {
    return bankServiceImpl;
  }



  public void setBankServiceImpl(BankServiceImpl bankServiceImpl) {
    this.bankServiceImpl = bankServiceImpl;
  }



  /**------logger ----.*/
	Logger log = Logger.getLogger(BankController.class.getName());
	
	/**creating a bank, passing wrapper class object having some amount as arguments. 
	 * @param amount
	 * @return
	 * @throws HandleException
	 */
	@PostMapping("/createbank")
	public ResponseEntity<?> callCreateBank( @RequestBody  WrapperCreateBank object) throws HandleException
	{
	  log.info("calling createBank");
		System.out.println(object.getAmount());
		Bank bank= new Bank(object.getAmount());
		Bank bank1 =  bankServiceImpl.createBank(object);
		if(bank1!=null)
		{return new ResponseEntity<Bank>(bank1, HttpStatus.OK);}
		else
		{return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}

	}
	
	
	
	/** showing bank details.
	 * @return
	 * @throws HandleException
	 */
	@GetMapping("/getbankdetails")
	public ResponseEntity<?> getBankDetails() throws HandleException
	{
	  
	  log.info("calling getBankDetails");
		List<Bank> bankslist = new ArrayList<Bank>(); 
		bankslist = bankServiceImpl.getBankDetails();
		
		if(bankslist!=null)
		{return new ResponseEntity<List<Bank>>(bankslist, HttpStatus.OK);}
		else
		{return new ResponseEntity<String>(environment.getProperty("999"), HttpStatus.BAD_REQUEST);}
		
	}
	
	
	
}
