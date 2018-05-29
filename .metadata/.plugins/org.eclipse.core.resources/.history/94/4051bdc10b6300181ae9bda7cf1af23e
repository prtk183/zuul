package com.sbank.service;

import java.util.List;
import java.util.Map;

import com.sbank.exception.HandleException;
//import com.sbank.model.Atm_Denomination;
import com.sbank.model.Bank_Denomination;
import com.sbank.model.RefMoney;
import com.sbank.wrappers.WrapperDenomination;
import com.sbank.wrappers.WrapperRequestObject;
import com.sbank.wrappers.WrapperUpdateDenomination;

public interface DenominationService {

  WrapperDenomination initialzeDenomination() throws HandleException;;
  
  WrapperDenomination getDenomination(WrapperRequestObject object) throws HandleException;
 
  void addDenominations(WrapperUpdateDenomination object) throws HandleException;
  
  void subDenominations(WrapperUpdateDenomination object) throws HandleException;

  
  List<Integer> getAvailableRefernceTable() throws HandleException;
  
  List<Integer> getValidRefernceTable() throws HandleException;
  
}
