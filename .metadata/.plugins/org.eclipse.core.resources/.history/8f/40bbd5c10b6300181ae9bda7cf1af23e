package com.sbank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbank.dao.BankDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Atm_Denomination;
import com.sbank.model.Bank;
import com.sbank.model.Bank_Denomination;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.WrapperDenomination;
import com.sbank.wrappers.WrapperRequestObject;
import com.sbank.wrappers.WrapperUpdateDenomination;

@Service
public class BankDenominationServiceImpl implements DenominationService{

  /**-------bankServiceImpl object-----.*/
  @Autowired 
  BankServiceImpl bankServiceImpl;
  
  /**----------------bankDenominationRepository------------------------.*/
  @Autowired
  BankDenominationRepository bankDenominationRepository;
  
Logger log = Logger.getLogger("in bankdenomination impl");
  

  /**----------------------refMoneyServiceImpl--------------------------.*/
  @Autowired
  RefMoneyServiceImpl refMoneyServiceImpl;
  
  /** getting requestamount and bank id and returrning the denomination with its count.
   * @see com.sbank.service.DenominationService#
   * \t getDenominationPermission(com.sbank.wrappers.BankPermission)
   */
  @Override
  public WrapperDenomination getDenomination(WrapperRequestObject object) throws HandleException {
    
    log.info("in get denomination method");
   
    /**-------result -------.*/
    WrapperDenomination result=new WrapperDenomination(null, false);
    
    /**--------denomination table--------.*/
    Map<Integer, Integer> denomtable = new HashMap<Integer, Integer>();
    
    List<Integer> availableDenomination = object.getRefernceTable();
    
   
    if(object.getRequestamount()!=null && object.getId()!=null)
    {
      
            Integer amount = object.getRequestamount().intValue();
            Random random = new Random();
            
            if(availableDenomination.isEmpty()==false)
            {
                while(amount.compareTo(99)==1 && availableDenomination.isEmpty()!=true)
                {
                  int count=0;
                  Integer index = availableDenomination.get(random.nextInt(availableDenomination.size()));
                 
                    if(amount>=index)
                    {
                      count = amount/index;
                      amount = amount%index;
                      availableDenomination.remove(index);
                      denomtable.put(index, count);
                    }
                }
                
                if(amount==0)
                {
                  result.setDenominationTable(denomtable);
                  result.setPermission(true);
                  System.out.println(result);
                  return result;
                  
                } else {
                  
                  throw new HandleException("invalid permission denided amount");
                }
                
              
            } else {
              throw new HandleException("invalid amount");
            }
        }
        else
        {
          throw new HandleException("Bank not found");
        }
      
    
   
    
  }

  /**
   * (non-Javadoc)
   * @see com.sbank.service.DenominationService#upadateDenominations(com.sbank.wrappers.WrapperDenomination)
   */
  @Override
  public void addDenominations(WrapperUpdateDenomination object) throws HandleException {
    log.info("in add update denomination ");

    List<Bank_Denomination> reftable = bankDenominationRepository.findAll();
  
    Map<Integer, Integer> updaterequesttable = object.getDenominationTable();
   
    
    for(Bank_Denomination ref : reftable)
    {
     
        for (Map.Entry<Integer,Integer> entry : updaterequesttable.entrySet()) 
        {
      
          if(ref.getCurrency().equals(entry.getKey()))
          {
            ref.setCount(ref.getCount()+entry.getValue());

          }
          
        }
        bankDenominationRepository.save(ref);
     }
    
  }
  
  
  /**
  /* (non-Javadoc)
   * @see com.sbank.service.DenominationService#subDenominations(com.sbank.wrappers.WrapperUpdateDenomination)
   */
  @Override
  public void subDenominations(WrapperUpdateDenomination object) throws HandleException {
    // TODO Auto-generated method stub
    
    log.info("in substract update denomination ");

    List<Bank_Denomination> reftable = bankDenominationRepository.findAll();
  
    Map<Integer, Integer> updaterequesttable = object.getDenominationTable();
   
    
    for(Bank_Denomination ref : reftable)
    {
     System.out.println("in chck"+ref);
        for (Map.Entry<Integer,Integer> entry : updaterequesttable.entrySet()) 
        {
      
          if(ref.getCurrency().equals(entry.getKey()) )
          {
     
            ref.setCount(ref.getCount().intValue() - entry.getValue().intValue());
            System.out.println("updating atm denom table "+ref.getCount());
            }
        
        
          }
          
        
        bankDenominationRepository.save(ref);
        
     }
    
  }

  @Override
  public WrapperDenomination initialzeDenomination() throws HandleException {
    log.info("in initialize denominationa");
    List<RefMoney> denomination = refMoneyServiceImpl.getRefTable();
    
    for(RefMoney ref : denomination)
    {
      Bank_Denomination object = new Bank_Denomination(ref.getCurrency(), 0);
      bankDenominationRepository.save(object);

    }
    return null;
  }

  @Override
  public List<Integer> getAvailableRefernceTable() throws HandleException {

      List<Bank_Denomination> dblist = bankDenominationRepository.findAll();
      
      List<Integer> refenctable = new ArrayList<Integer>();
      
      for(Bank_Denomination ref : dblist)
      {
        refenctable.add(ref.getCurrency());
      }
      
      return refenctable;
    
   
  }

  @Override
  public List<Integer> getValidRefernceTable() throws HandleException {
    
    
    List<Bank_Denomination> dblist = bankDenominationRepository.findAll();
    
    List<Integer> refenctable = new ArrayList<Integer>();
    
    for(Bank_Denomination ref : dblist)
    {
      if(ref.getCount()!=0)
      {
        refenctable.add(ref.getCurrency());
      }
    }
    
    return refenctable;

  }



}
