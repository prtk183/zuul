package com.szuul.service;

import java.util.List;

import com.szuul.exception.HandleException;
import com.szuul.model.RefMoney;

public interface RefMoneyService {

  
  /** updating existing currency
   * @param refMoney
   * @return
   * @throws HandleException
   */
  public  List<RefMoney> update(RefMoney refMoney) throws HandleException;

  /** getting existing currency
   * @return
   * @throws HandleException
   */
  public List<RefMoney> getRefTable() throws HandleException;
  
  /***/
  /**
   * @return
   * @throws HandleException
   */
  public List<Integer> getReferenceTable() throws HandleException;

}
