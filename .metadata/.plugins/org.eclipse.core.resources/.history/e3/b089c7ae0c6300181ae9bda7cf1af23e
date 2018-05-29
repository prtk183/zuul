/*package com.sbank.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank;
import com.sbank.model.Customer;
import com.sbank.service.CustomerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("application.properties")
public class CustomerTestCase {

  *//**----------environment object to get in application properties---------------------.*//*
  @Autowired
  private Environment environment;
  
  *//**-----------to mock customer repo ------.*//*
  @Mock
  private CustomerRepository custmerRepo;
  
  *//**------------to  mock bank repo---------------.*//*
  @Mock
  private BankRepository bankRepo;
  
  *//**---------------inject customer service--------.*//*
  @InjectMocks
  private CustomerServiceImpl customerService;
  
  @Test
  public void TestCustomerSucccess() throws HandleException
  {
    final Bank bank = new Bank(1L,new BigDecimal(1000));
    final Customer customer=new Customer(2L,"abc",103203, bank);
    final Optional<Bank> tempBank=Optional.of(bank);
    when(bankRepo.findById(1L)).thenReturn(tempBank);
    when(custmerRepo.save(Mockito.<Customer>any())).thenReturn(customer);
    assertEquals("abc",customerService.createCustomer(customer).getCustomerName());
  }
  
  @Test(expected=HandleException.class)
  public void TestCustomerFailureNullArguments() throws HandleException {
    final Bank bank = new Bank(1L,new BigDecimal(1000));
    final Customer customer=new Customer(2L,null,103203, bank);
    final Optional<Bank> tempBank=Optional.of(bank);
    when(customerService.createCustomer(customer)).thenThrow(new HandleException(environment.getProperty("7777")));
    
  }
  

  @Test(expected=HandleException.class)
  public void TestCustomerFailureNullBank() throws HandleException {
    final Bank bank = null;
    final Customer customer=new Customer(null,103203, bank);
    final Optional<Bank> tempBank=Optional.of(bank);
    when(customerService.createCustomer(customer)).thenThrow(new HandleException(environment.getProperty("7777")));
    
  }
  
  
}
*/