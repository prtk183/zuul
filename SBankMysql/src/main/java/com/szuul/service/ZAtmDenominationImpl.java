/*package com.sbank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AtmDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Atm_Denomination;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class ZAtmDenominationImpl implements AtmDenominationService{
  
  *//**---------atmDenominationRepository object---------------.*//*
  @Autowired
  private AtmDenominationRepository atmDenominationRepository;
  
  *//**---------atmService object---------------.*//*
  @Autowired
  private ATMService atmService;
  
  *//**---------environment object---------------.*//*
  @Autowired
  private Environment environment;

  

  *//** this will give atm_denomination object.
   * @see com.sbank.service.AtmDenominationService#giveDenomination(java.lang.Long, java.math.BigDecimal)
   *//*
  @Override
  @Transactional
  public Atm_Denomination giveDenomination(Long atmId, BigDecimal requestAmount) throws HandleException{
    
   //case 1 i have 2000, 500, 200, 100
    
   Map<Integer, Integer> noofdenom = new HashMap<Integer, Integer>();
   List<Integer> denomination = new ArrayList<Integer>();
   denomination.add(2000);
   denomination.add(500);
   denomination.add(200);
   denomination.add(100);

    if(atmService.getAtm(atmId).getATMId().equals(atmId) && requestAmount.intValue()%2==0 && requestAmount!=null)  //checking existing atm
    {
      final BigDecimal amount = requestAmount;

        
        if(amount.remainder(new BigDecimal(2)).equals(new BigDecimal(0)) && amount.compareTo(new BigDecimal(100))==1) 
        {
            System.out.println("in comarision");
            BigDecimal twothousand = new BigDecimal(2000);
            Integer thowthousandcount=0;
            BigDecimal fivehundres = new BigDecimal(500);
            Integer fivehundredcount = 0;
            BigDecimal twohundred = new BigDecimal(200);
            Integer thwohundredcount = 0;
            BigDecimal hundred = new BigDecimal(100);
            Integer hundredcount=0;
        
            int take = amount.intValue();
              while(take!=0)
              {
              
                  if(take>=2000)
                    {
                      thowthousandcount=take/2000;
                      take=take%2000;
                    }
                  else if(take>=500)
                      {
                        fivehundredcount=take/500;
                        take=take%500;
                
                      }
                      else if(take>=200)
                            {
                                thwohundredcount=take/200;
                                take=take%200;
                            }
                            else if(take>=100)
                                  {
                                    hundredcount=take/100;
                                    take=take%100;
                                  }
                                  else if(take<100)
                                        {
                                            throw new HandleException("invalid amount");
                                        }
              
            
              
                  }
 

                  noofdenom.put(2000, thowthousandcount);
                  noofdenom.put(500, fivehundredcount);
                  noofdenom.put(200, thwohundredcount);
                  noofdenom.put(100, hundredcount);
            
                  Atm_Denomination atmobject = new Atm_Denomination(atmId, requestAmount, denomination, noofdenom);
                  atmDenominationRepository.save(atmobject);
                  return atmobject;
            
        } else {
          throw new HandleException(environment.getProperty("601"));
        }
      
    } else {
      throw new HandleException(environment.getProperty("666"));
    }
    
    
   
  }

}
*/