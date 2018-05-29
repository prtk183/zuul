package com.szuul.service;

import java.util.List;
import java.util.Map;

import com.szuul.exception.HandleException;
//import com.szuul.model.Atm_Denomination;
import com.szuul.model.Bank_Denomination;
import com.szuul.model.RefMoney;
import com.szuul.wrappers.WrapperDenomination;
import com.szuul.wrappers.WrapperRequestObject;
import com.szuul.wrappers.WrapperUpdateDenomination;

public interface DenominationService {

  WrapperDenomination initialzeDenomination() throws HandleException;;
  
  WrapperDenomination getDenomination(WrapperRequestObject object) throws HandleException;
 
  void addDenominations(WrapperUpdateDenomination object) throws HandleException;
  
  void subDenominations(WrapperUpdateDenomination object) throws HandleException;

  
  List<Integer> getAvailableRefernceTable() throws HandleException;
  
  List<Integer> getValidRefernceTable() throws HandleException;
  
}
