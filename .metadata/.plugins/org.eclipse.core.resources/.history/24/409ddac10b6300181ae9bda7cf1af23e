package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sbank.dao.ATMRepository;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.ATM;
import com.sbank.model.Account;
//import com.sbank.model.Atm_Denomination;
import com.sbank.model.Bank;
//import com.sbank.model.Bank_Denomination;
import com.sbank.wrappers.WrapperATMAddMoneyToATM;
import com.sbank.wrappers.WrapperATMCreate;
import com.sbank.wrappers.WrapperATMWithdraw;
import com.sbank.wrappers.WrapperDenomination;
import com.sbank.wrappers.WrapperRequestObject;
import com.sbank.wrappers.WrapperTransaction;
import com.sbank.wrappers.WrapperUpdateDenomination;

/**
 * @author hp
 *
 */
@Service
public class ATMServiceImpl implements ATMService {

  /**---------bankServiceImpl object------------.*/
  @Autowired
  private BankServiceImpl bankServiceImpl;
  
  /**--------atm repository object---------*/
  @Autowired
  private ATMRepository atmrepository;
  
  /**---------accountServiceImpl object--------*/
  @Autowired
  private AccountServiceImpl accountServiceImpl;
  
  
  @Autowired
  private AtmDenominationServiceImpl atmDenominationServiceImpl;
  
  @Autowired
  private BankDenominationServiceImpl bankDenominationServiceImpl;
  
  @Autowired
  private TransactionServiceImpl transactionServiceImpl;
  
  @Autowired
  private CustomerServiceImpl customerServiceImpl; 
  
  /**-------environment object-------.*/
  @Autowired
  private Environment environment;
  
  /**-------------log -------*/
 public  Logger log = Logger.getLogger(ATMServiceImpl.class.getName());

  /*
   * @parameter amount and bankid
   * @return atm
   * @see com.sbank.service.ATMService#createATM(com.sbank.wrappers.WrapperATMCreate)
   */
  @Override
  public ATM createATM(final WrapperATMCreate object) throws HandleException {
    
    if( object.getAmount()!=null && object.getBankId()!=null)
    {
        log.info("in atm service creating atm");
        ATM atm = new ATM();
        atm.setAmount(object.getAmount());
        atm.setBank(bankServiceImpl.getBank(object.getBankId()));
        atmDenominationServiceImpl.initialzeDenomination();
        atm = atmrepository.save(atm);
        return atm;
    } else {
      throw new HandleException(environment.getProperty("7777"));
    }
  }

  /*
   * requesting amount to bank and transfering to atm
   * @see com.sbank.service.ATMService#addMoneyFromBank(com.sbank.wrappers.WrapperATMAddMoneyToATM)
   */
  @Override
  public ATM addMoneyFromBank(final WrapperATMAddMoneyToATM object) throws HandleException {
    log.info("in atm service addMoneyFromBank");

    if(object.getAmount()!=null && object.getAtmID()!=null && object.getBankId()!=null)
    {
        if (atmrepository.findByatmId(object.getAtmID()).isPresent()
            && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())) //validating input data
        {
          
            ATM atm = atmrepository.findByatmId(object.getAtmID()).get();
            atm.setAmount(atm.getAmount().add(object.getAmount()));
            atm.setBank(bankServiceImpl.getBank(object.getBankId()));

            Bank bank = bankServiceImpl.getBank(object.getBankId());

            BigDecimal bankamount = bank.getAmount();
            BigDecimal validamount = new BigDecimal(100);

            if (object.getAmount().compareTo(bankamount) == -1
                && object.getAmount().compareTo(validamount) == 1) // checking for valid amount transefer request
            {
              

              WrapperRequestObject PObject = new WrapperRequestObject();
              PObject.setId(object.getAtmID());
              PObject.setRequestamount(object.getAmount());
              List<Integer> atmreftable = bankDenominationServiceImpl.getValidRefernceTable();
              PObject.setRefernceTable(atmreftable);
    
              
              WrapperDenomination permission = atmDenominationServiceImpl.getDenomination(PObject);
              
              if (permission.getPermission() == true && object.getAmount().intValue()%2==0 ) 
              {
                WrapperUpdateDenomination update = new WrapperUpdateDenomination();
                update.setDenominationTable(permission.getDenominationTable());
                Map<Integer, Integer> suggested = permission.getDenominationTable();
                for (Map.Entry<Integer,Integer> entry : suggested.entrySet()) 
                {
                  System.out.println("Currency "+entry.getKey()+"count"+entry.getValue());

                }

          

                bankDenominationServiceImpl.subDenominations(update); //subtracting from bank
           

                atmDenominationServiceImpl.addDenominations(update); //adding itno atm
             

               bank.setAmount(bank.getAmount().subtract(object.getAmount()));
               bankServiceImpl.updateBank(bank);
               atm = atmrepository.save(atm);
               return atm;
              } else {
                throw new HandleException("amount denied");

              }

            } else {
              throw new HandleException(environment.getProperty("401"));
            }
        } else {
            throw new HandleException(environment.getProperty("400"));
        }
    } else {
      throw new HandleException(environment.getProperty("7777"));
    }
  }

  /* requesting an amount validating acrross atm - bank- account and accepting it
   * @see com.sbank.service.ATMService#withdrawMoney(com.sbank.wrappers.WrapperATMWithdraw)
   */
  @Override
  public ATM withdrawMoney(WrapperATMWithdraw object) throws HandleException {
    log.info("in atm service WrapperATMWithdraw");
    
    if(object.getAccountId()!=null && object.getAmount()!=null && object.getAtmId()!=null && object.getBankId()!=null)
    {
      if(atmrepository.findByatmId(object.getAtmId()).isPresent() 
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
        && accountServiceImpl.getAccountDetail(object.getAccountId()).getAccountId().equals(object.getAccountId()))   //validating the data
         {
            ATM atm = atmrepository.findByatmId(object.getAtmId()).get();
            BigDecimal initial = new BigDecimal(100);
            BigDecimal validamount = new BigDecimal(100);
            if(object.getAmount().compareTo(atm.getAmount())==-1 && object.getAmount().compareTo(validamount)==1)   //validating request wrt to atm
            {
               
                Bank bank = bankServiceImpl.getBank(object.getBankId());
                
                if((object.getAmount().compareTo(bank.getAmount())==-1) &&
                    (object.getAmount().compareTo(validamount))==1) //validating the requested amount wrt bank                                                                                             //against money in atm
                {
                           Account account = accountServiceImpl.getAccountDetail(object.getAccountId());
                           
                          if((object.getAmount().compareTo(account.getAmount())==-1 || object.getAmount().compareTo(account.getAmount())==0)
                          && object.getAmount().compareTo(validamount)==1 )   //validating wrt to account
                          {
                            
                            WrapperRequestObject PObject = new WrapperRequestObject();
                            PObject.setId(object.getAtmId());
                            PObject.setRequestamount(object.getAmount());
                            List<Integer> atmreftable = atmDenominationServiceImpl.getValidRefernceTable();
                            PObject.setRefernceTable(atmreftable);
                            
                            WrapperDenomination permission = atmDenominationServiceImpl.getDenomination(PObject);
                            
                            if (permission.getPermission() == true && object.getAmount().intValue()%2==0 ) 
                            {
                              atm.setAmount(atm.getAmount().subtract(object.getAmount())); 
                              account.setAmount(account.getAmount().subtract(object.getAmount()));

                          
                            //when all validation is succesfull, saving into corresponding tables
                           
                              final String transactionType = "Withdraw";
                              WrapperTransaction Obj = new WrapperTransaction(accountServiceImpl.getAccountDetail(object.getAccountId()).getCustomer().getCustomerId(),
                              object.getAccountId(), transactionType, object.getAmount());
                              transactionServiceImpl.createTransaction(Obj);
                              WrapperUpdateDenomination sendUpdate = new WrapperUpdateDenomination(permission.getDenominationTable());
                              atmDenominationServiceImpl.subDenominations(sendUpdate);
                              accountServiceImpl.updateAccount(account);
                              
                              atmrepository.save(atm);

                            return atm;
                            
                          }
                            else
                            {
                              throw new HandleException(environment.getProperty("402")); 
                            }
                            
                       } else {
                                 throw new HandleException(environment.getProperty("403"));
                      }
                   
                } else {
                          throw new HandleException(environment.getProperty("405"));
                }
            } else {
              throw new HandleException(environment.getProperty("406"));
            }
         } else {
                 throw new HandleException(environment.getProperty("400"));

         }
    } else {
      throw new HandleException(environment.getProperty("7777"));

    }
    
  }

  @Override
  public ATM getAtm(Long atmId) throws HandleException {
    log.info("in atm service getAtm");
    if(atmId!=null)
    {
    return (atmrepository.findByatmId(atmId)).get();
    }
    else
    {
      throw new HandleException(environment.getProperty("7777"));

    }
  }

}
