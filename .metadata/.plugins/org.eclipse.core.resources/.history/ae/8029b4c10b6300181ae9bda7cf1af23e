package com.sbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.dao.RefMoneyRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.RefMoney;

@Service
public class RefMoneyServiceImpl implements RefMoneyService{

  /**-----------refmoney repositry------------.*/
  @Autowired
  RefMoneyRepository refMoneyRepository;
  
  Logger log = Logger.getLogger(RefMoneyServiceImpl.class.getName());

  /** updating records  in repository
  /* (non-Javadoc)
   * @see com.sbank.service.RefMoneyService#update(com.sbank.model.RefMoney)
   */
  @Override
  public  List<RefMoney> update(RefMoney refMoney) throws HandleException{
   
    refMoneyRepository.save(refMoney);
    log.info("in ref update ");
    return  (List<RefMoney>) refMoneyRepository.findAll();
  }
  
  /** getting available table
   * @see com.sbank.service.RefMoneyService#getRefTable()
   */
  @Override
  public List<RefMoney> getRefTable() throws HandleException {

    
    
    log.info("in ref get ref update ");
    return (List<RefMoney>) refMoneyRepository.findAll();
  }

  /**
  /* (non-Javadoc)
   * @see com.sbank.service.RefMoneyService#getReferenceTable()
   */
  @Override
  public List<Integer> getReferenceTable() throws HandleException {
    // TODO Auto-generated method stub
    
    List<RefMoney> dblist = refMoneyRepository.findAll();
    
    List<Integer> refenctable = new ArrayList<Integer>();
    
    for(RefMoney ref : dblist)
    {
      refenctable.add(ref.getCurrency());
    }
    
    return refenctable;
  }
  
  

}
