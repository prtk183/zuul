package com.szuul.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.szuul.controller.BankController;
import com.szuul.dao.BankRepository;
import com.szuul.exception.HandleException;
import com.szuul.model.Bank;
import com.szuul.service.BankDenominationServiceImpl;
import com.szuul.service.BankServiceImpl;
import com.szuul.wrappers.WrapperCreateBank;
import com.szuul.wrappers.WrapperDenomination;

@RunWith(MockitoJUnitRunner.class)
public class NewBankTestCase {

  @InjectMocks
  BankController bankCont;
  
  @Mock
  BankServiceImpl bankServiceImpl ; 
  
  @InjectMocks
  BankServiceImpl bankServiceImpl1 ; 
  
  @Mock
  BankDenominationServiceImpl bankDenominationServiceImpl ;
  
  @Mock
  private BankRepository bankrepository;
  
  @Test
  public void callCreateBankTest() throws HandleException {
    
    WrapperCreateBank wrapperObj = new WrapperCreateBank();
    wrapperObj.setAmount(new BigDecimal(1000));
    BankServiceImpl service = new BankServiceImpl();
    bankCont.setBankServiceImpl(service);
   // Mockito.when(bankDenominationServiceImpl.initialzeDenomination()).thenReturn(createBankDenomObj());
    bankCont.callCreateBank(wrapperObj);
    
  }
  
  @Test
  public void callCreateBankTest0() throws HandleException {
    
    WrapperCreateBank wrapperObj = new WrapperCreateBank();
    wrapperObj.setAmount(new BigDecimal(1000));
    bankCont.setBankServiceImpl(bankServiceImpl1);
    
    bankCont.callCreateBank(wrapperObj);
    
  }
  
  
  @Test
  public void callCreateBankTest1() throws HandleException {
    
    WrapperCreateBank wrapperObj = new WrapperCreateBank();
    wrapperObj.setAmount(new BigDecimal(100));
  
    Bank bank= new Bank(new BigDecimal(100)); 
    
    Mockito.when(bankServiceImpl.createBank(wrapperObj)).thenReturn(bank);
    
   ResponseEntity<Bank> resp = (ResponseEntity<Bank>) bankCont.callCreateBank(wrapperObj);
    assertEquals(bank, resp.getBody());
  }

  
  private WrapperDenomination createBankDenomObj() {
    Map<Integer, Integer> denominationTable = new HashMap<Integer, Integer>();
    denominationTable.put(1000, 0);
    denominationTable.put(500, 0);
    denominationTable.put(100, 0);
    Boolean permission= true;

     return new WrapperDenomination(denominationTable,permission );
  }
}
