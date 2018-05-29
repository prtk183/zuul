/*package com.sbank.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.dao.BankDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Bank_Denomination;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.BankPermission;

@Service
public class ZBankDenominationImpl implements BankDenominationService{

  @Autowired
  BankServiceImpl bankServiceImpl;
  

  @Autowired
  BankDenominationRepository bankDenominationRepository;
  
  @Autowired
  Environment environment;
  
  @Override
  public boolean getDenominationPermission(BankPermission object) throws HandleException {
    
    Boolean flag=false;
    Integer total =0;
    Integer amount = object.getRequestamount().intValue();
   
    //denominations
    final RefMoney ref = new RefMoney();
    
     Integer twothousand = ref.getTwothousanddenomination();
     Integer fivehundred = ref.getFivehundreddenomination();
     Integer hundred = ref.getHundreddenomination();
    
    
    Integer twothousandCount=0, fivehundredCount=0, hundredCount=0;
    
    if(amount % 2==0 && amount>=100)
    {
      flag=true;
      while(amount!=0)
      {
        if(amount>=twothousand)
        {
          twothousandCount=amount/twothousand;
          amount=amount%twothousand;
        } else if(amount>=500 && amount<=2000) {
          fivehundredCount=amount/fivehundred;
                  amount=amount%fivehundred;
                } else if(amount>=100) {
                  hundredCount=amount/hundred;
                            amount=amount%hundred;
                        } else if(amount<100)
                            {
                              flag=false;
                            }
        
      }
      
  
     total = twothousand * twothousandCount + fivehundred * fivehundredCount + hundred * hundredCount; 
    }
    else
    {
      flag = false;
    }
    
    
    if(flag==true)
    {
      if(object.getRequestamount().intValue()==total)
      {
        Bank_Denomination updatedenominationtable = new Bank_Denomination(bankServiceImpl.getBank(object.getId()), object.getRequestamount(), twothousandCount, fivehundredCount, hundredCount);
        if(updatedenominationtable!=null)
        { bankDenominationRepository.save(updatedenominationtable);
        flag=true;}
        else
        { throw new HandleException(environment.getProperty("911"));}
    }
    }
    else
    {
      flag = false;
    }
    return flag;
}
}
*/