package com.szuul.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.szuul.dao.AccountRepository;
import com.szuul.dao.BankRepository;
import com.szuul.dao.CustomerRepository;
import com.szuul.exception.HandleException;
import com.szuul.model.Account;
import com.szuul.model.Bank;
import com.szuul.model.Customer;
import com.szuul.service.AccountServiceImpl;
import com.szuul.service.BankServiceImpl;
import com.szuul.service.CustomerServiceImpl;
import com.szuul.wrappers.CreateAccountWrapper;

public class AccountTestCase {

  @InjectMocks
  AccountServiceImpl accountService;
 
  @Mock
  BankServiceImpl bankServiceImpl;
  @Mock
  CustomerServiceImpl customerServiceImpl;
  @Mock
  AccountRepository accountRepo;
  
 /* @Test
  public void TestCreateAccount() throws HandleException
  {
    final Bank bank=new Bank(1L,new BigDecimal(100));
    when(bankServiceImpl.getBank(1L)).thenReturn(bank);

    final Customer customer=new Customer(2L,"never",11111,bank);
    when(customerServiceImpl.getCustomer(2L)).thenReturn(customer);
    
    final Account account=new Account(3L,new BigDecimal(100),bank, customer);
    CreateAccountWrapper object = new CreateAccountWrapper(2L, 1L,new BigDecimal(100) );
    //when(bankServiceImpl.updateBank(Mockito.<Bank>any())).thenReturn();
    
    when(accountRepo.save(Mockito.<Account>any())).thenReturn(account);
    assertEquals(account.getBank(),accountService.createAccount(object).getBank());*/
    
//  }
  
 
  
}
