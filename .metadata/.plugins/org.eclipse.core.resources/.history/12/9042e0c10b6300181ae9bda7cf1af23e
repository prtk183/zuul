package com.sbank.service;

import java.math.BigDecimal;

import com.sbank.dao.AtmDenominationRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.model.Atm_Denomination;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.WrapperDenomination;
import com.sbank.wrappers.WrapperRequestObject;
import com.sbank.wrappers.WrapperUpdateDenomination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AtmDenominationServiceImpl implements DenominationService {
  
  Logger log = Logger.getLogger("in atmDenomination");
  
  /**----------------refMoneyServiceImpl-----------------------.*/
  @Autowired
  private RefMoneyServiceImpl refMoneyServiceImpl;
  
  /**----------------------atmDenominationRepository---------------------------.*/
  @Autowired
  private AtmDenominationRepository atmDenominationRepository;
  

  /** intitalizing denomination count
   * @see com.sbank.service.DenominationService#initialzeDenomination()
   */
  @Override
  public WrapperDenomination initialzeDenomination() throws HandleException {
    
    log.info("in initialize atm denominationa");
    List<RefMoney> denomination = refMoneyServiceImpl.getRefTable();
    
    for(RefMoney ref : denomination)
    {
      Atm_Denomination object = new Atm_Denomination(ref.getCurrency(), 0);
      atmDenominationRepository.save(object);

    }
    return null;
    
   
  }

  /** getting denomination count and permmision
  /* (non-Javadoc)
   * @see com.sbank.service.DenominationService#getDenomination(com.sbank.wrappers.WrapperRequestObject)
   */
  @Override
  public WrapperDenomination getDenomination(WrapperRequestObject object) throws HandleException {
    
    log.info("in get atm denomination method");
    
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

  /** adding  denominations currencies count
   * @see com.sbank.service.DenominationService#addDenominations(com.sbank.wrappers.WrapperUpdateDenomination)
   */
  @Override
  public void addDenominations(WrapperUpdateDenomination object) throws HandleException {
   
    
    log.info("in update denomination ");

    List<Atm_Denomination> reftable = atmDenominationRepository.findAll();
  
    Map<Integer, Integer> updaterequesttable = object.getDenominationTable();
   
    
    for(Atm_Denomination ref : reftable)
    {
     
        for (Map.Entry<Integer,Integer> entry : updaterequesttable.entrySet()) 
        {
      
          if(ref.getCurrency().equals(entry.getKey()))
          {
            ref.setCount(ref.getCount()+entry.getValue());

          }
          
        }
        atmDenominationRepository.save(ref);
     }
    
    
  }

  /** substracting count after  withdrawal
   * @see com.sbank.service.DenominationService#subDenominations(com.sbank.wrappers.WrapperUpdateDenomination)
   */
  @Override
  public void subDenominations(WrapperUpdateDenomination object) throws HandleException {
    
    log.info("in update denomination ");

    List<Atm_Denomination> reftable = atmDenominationRepository.findAll();
  
    Map<Integer, Integer> updaterequesttable = object.getDenominationTable();
   
    
    for(Atm_Denomination ref : reftable)
    {
     
        for (Map.Entry<Integer,Integer> entry : updaterequesttable.entrySet()) 
        {
      
          if(ref.getCurrency().equals(entry.getKey()))
          {
            if( ref.getCount()!=0  && ref.getCount()>entry.getValue())
            {
           
            
            ref.setCount(ref.getCount()-entry.getValue());}

          }
          
        }
        atmDenominationRepository.save(ref);
        
     }
  }

  
  /** getting existing amount reference table  
   * @see com.sbank.service.DenominationService#getAvailableRefernceTable()
   */
  @Override
  public List<Integer> getAvailableRefernceTable() throws HandleException {
    
    
    List<Atm_Denomination> dblist = atmDenominationRepository.findAll();
    
    List<Integer> refenctable = new ArrayList<Integer>();
    
    for(Atm_Denomination ref : dblist)
    {
      refenctable.add(ref.getCurrency());
    }
    
    return refenctable;
  
 
  }

  @Override
  public List<Integer> getValidRefernceTable() throws HandleException {
    
    
    List<Atm_Denomination> dblist = atmDenominationRepository.findAll();
    
    List<Integer> refenctable = new ArrayList<Integer>();
    
    for(Atm_Denomination ref : dblist)
    {
      if(ref.getCount()!=0)
      {
        refenctable.add(ref.getCurrency());
      }
    }
    
    return refenctable;
  
 
  }
  



}
