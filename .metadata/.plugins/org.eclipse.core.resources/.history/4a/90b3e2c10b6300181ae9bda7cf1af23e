package com.sbank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;


import com.sbank.wrappers.CreateAccountWrapper;
import com.sbank.wrappers.WrapperAccountDeposite;
import com.sbank.wrappers.WrapperDenomination;
import com.sbank.wrappers.WrapperRequestObject;
import com.sbank.wrappers.WrapperTransaction;
import com.sbank.wrappers.WrapperUpdateDenomination;
import com.sbank.dao.AccountRepository;
import com.sbank.dao.BankRepository;
import com.sbank.dao.CustomerRepository;
import com.sbank.exception.HandleException;
import com.sbank.model.Account;
import com.sbank.model.Bank;
//import com.sbank.model.Bank_Denomination;
import com.sbank.model.Customer;
import com.sbank.model.Transaction;

@Service
public class AccountServiceImpl implements AccountService {

  /**--------logger log object-------------------*/
  private Logger log = Logger.getLogger(AccountServiceImpl.class.getName());
  
  /**-----environment variable------.*/
  @Autowired
 private  Environment environment;
  
  /**-------customerServiceImpl object--------.*/
  @Autowired
  private CustomerServiceImpl customerServiceImpl;
  
  /**-----------bankServiceImpl object------------.*/
  @Autowired
  private BankServiceImpl bankServiceImpl;
  
  /**-----------accountRepository object--------------*/
  @Autowired
  private AccountRepository accountRepository;
  
  /**---------------transactionServiceImpl object-----------------.*/
  @Autowired
  private TransactionServiceImpl transactionServiceImpl;
  
  /**----------------bankdenominationImpl object----------------------------.*/
  @Autowired
  private BankDenominationServiceImpl bankdenominationServiceImpl;
  
  @Autowired
  private RefMoneyServiceImpl refMoneyServiceImpl;
 
  /**
   * creating an account.
   * 
   * @see com.sbank.service.AccountService#createAccount(com.sbank.wrappers.CreateAccountWrapper)
   */
  @Override
  @Transactional
  public Account createAccount(final CreateAccountWrapper object) throws HandleException {
    log.info(" in creating account");

    Account account = new Account();
if(object.getBankId()!=null && object.getAmount()!= null)
{
    if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId()
        .equals(object.getCustomerId())
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
        && object.getAmount().intValue() % 2 == 0 ) 
      {

            account.setAmount(object.getAmount());
            Customer cust = customerServiceImpl.getCustomer(object.getCustomerId());
            account.setCustomer(cust);
            Bank bank = bankServiceImpl.getBank(object.getBankId());
            account.setBank(bank);

            BigDecimal initial = bank.getAmount();
            BigDecimal updated = initial.add(object.getAmount());

            bank.setAmount(updated);
            bankServiceImpl.updateBank(bank);
            account = accountRepository.save(account);
            return account;
      } else {
            
        log.warning(environment.getProperty("301"));
      throw new HandleException("301"); // if bank or customer is not
                                                                     // found
    }
    
}
else
{
  throw new HandleException("7777");
}
  }

  /**get account details of all account.
   * 
   * @see com.sbank.service.AccountService#getAccountDetails()
   */
  @Override
  public List<Account> getAccountDetails() throws HandleException {
    // TODO Auto-generated method stub
    log.info(" in  getAccountDetails");
    List<Account> accountList = null;
    accountList = accountRepository.findAll();
    return accountList;
  }

  /**deposit amount update account and bank.
   * @parameters: object containing customerid, bankid, accountid and amount to deposit
   * 
   * @return: updated account
   */
  @Override
  @Transactional
  public Account depositeMoney(final WrapperAccountDeposite object) throws HandleException {
    // TODO Auto-generated method stub
    Account act = null;
    log.info(" in  depositeMoney");
 if( object.getAmount()!=null && object.getBankId()!=null && object.getCustomerId()!=null)
{
      if (customerServiceImpl.getCustomer(object.getCustomerId()).getCustomerId()
        .equals(object.getCustomerId()) //// checking valid customer and bank
        && bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId()))
      {

          final Bank bank = bankServiceImpl.getBank(object.getBankId());
          act = accountRepository.findByaccountId(object.getAccountId()).get();

          final BigDecimal val = new BigDecimal(100);
          final BigDecimal initialamountinaccount = act.getAmount();
          final BigDecimal initialamountinbank = bank.getAmount();

            if (object.getAmount().compareTo(val) == 1 )
             {
       
                final WrapperRequestObject bpobject = new WrapperRequestObject();
                bpobject.setId(object.getBankId());
                bpobject.setRequestamount(object.getAmount());
                List<Integer> refernceTable = refMoneyServiceImpl.getReferenceTable();
                bpobject.setRefernceTable(refernceTable);
        
                WrapperDenomination permission = bankdenominationServiceImpl.getDenomination(bpobject);
                
                  if (permission.getPermission() == true && object.getAmount().intValue()%2==0 ) 
                  {
          
                      BigDecimal updatedbank = initialamountinbank.add(object.getAmount()); // adding depositing
                      // into bank

                      BigDecimal updatedact = initialamountinaccount.add(object.getAmount()); // adding depositing
                      // in account
          
                      act.setAmount(updatedact);
                      bank.setAmount(updatedbank);
                      String transactionType = "Deposit";
              
          
                      WrapperTransaction Object = new WrapperTransaction(object.getCustomerId(),
                          object.getAccountId(), transactionType, object.getAmount());

                      final Transaction transaction = transactionServiceImpl.createTransaction(Object);
                      WrapperUpdateDenomination sendUpdate = new WrapperUpdateDenomination(permission.getDenominationTable());
                      bankdenominationServiceImpl.addDenominations(sendUpdate);
                      accountRepository.saveAndFlush(act);
                      bankServiceImpl.updateBank(bank);
                      return act;
                  } else {
                        throw new HandleException(environment.getProperty("701"));
                  }
             } else {
                       throw new HandleException(environment.getProperty("302"));
             }
      } else {
          throw new HandleException(environment.getProperty("300"));
      }

    
} else {
   throw new HandleException(environment.getProperty("7777"));
}

}


  /**withdraw money from atm--bank--account.
   * 
   * @see com.sbank.service.AccountService#withdrawMoney(com.sbank.wrappers.WrapperAccountDeposite)
   */
  @Override
  @Transactional
  public Account withdrawMoney(final WrapperAccountDeposite object) throws HandleException {
    Account act = null;
    Bank bank = null;
    BigDecimal val = object.getAmount();
    log.info(" in  withdrawMoney");
    
    if(object.getAccountId()!=null && object.getAmount()!=null && object.getBankId()!=null && object.getCustomerId()!=null)
    {
          
        if (bankServiceImpl.getBank(object.getBankId()).getBankId().equals(object.getBankId())
                && accountRepository.findByaccountId(object.getAccountId()).isPresent()) 
        {
            bank = bankServiceImpl.getBank(object.getBankId());
            act = accountRepository.findByaccountId(object.getAccountId()).get();

            BigDecimal initialamountinaccount = act.getAmount();
            BigDecimal validamount = new BigDecimal(100);

            // withdrawing into bank
            final BigDecimal initialamountinbank = bank.getAmount();

            if (initialamountinbank.compareTo(validamount) == 1
                && object.getAmount().compareTo(initialamountinbank) == -1
                && object.getAmount().compareTo(validamount) == 1 && object.getAmount().intValue()%2==0) 
            {
             
              // withdrawing substracting in account
              if ((object.getAmount().compareTo(initialamountinaccount) == -1  || object.getAmount().compareTo(initialamountinaccount) == 0)
                  && object.getAmount().compareTo(validamount) == 1) 
                {
                

                final WrapperRequestObject bpobject = new WrapperRequestObject();
                bpobject.setId(object.getBankId());
                bpobject.setRequestamount(object.getAmount());
                List<Integer> refernceTable = bankdenominationServiceImpl.getAvailableRefernceTable();
                bpobject.setRefernceTable(refernceTable);
        
                WrapperDenomination permission = bankdenominationServiceImpl.getDenomination(bpobject);
                
                  if (permission.getPermission() == true && object.getAmount().intValue()%2==0 ) 
                  {
                
                    final BigDecimal updatebank= initialamountinbank.subtract(object.getAmount());
                    bank.setAmount(updatebank);
                
                    final BigDecimal updatedact = initialamountinaccount.subtract(object.getAmount()); 
                    act.setAmount(updatedact);
                  
                    final String transactionType = "Withdrawal";
                    WrapperTransaction Obj = new WrapperTransaction(object.getCustomerId(),
                    object.getAccountId(), transactionType, object.getAmount());
                    transactionServiceImpl.createTransaction(Obj);
                    WrapperUpdateDenomination sendUpdate = new WrapperUpdateDenomination(permission.getDenominationTable());
                    bankdenominationServiceImpl.subDenominations(sendUpdate);
                    accountRepository.saveAndFlush(act);
                    bankServiceImpl.updateBank(bank);
             
                    return act;
                  } else {
                    
                    throw new HandleException("permission denied");
                  }
                  
                } else {
                throw new HandleException(environment.getProperty("303"));
                }
            } else {
                      throw new HandleException(environment.getProperty("304"));
            }
        } else {
                  throw new HandleException(environment.getProperty("305"));
        }
    }
    else
    {
      throw new HandleException(environment.getProperty("7777"));
    }
    

  }

  /**get account details.
   * @parameter long account id
   * 
   * @return account
   */
  @Override
  public Account getAccountDetail(final Long Id) throws HandleException {
    log.info(" in  getAccountDetail");
    if(Id!=null )
    {
      return accountRepository.findByaccountId(Id).get();
    } else {
      throw new HandleException(environment.getProperty("7777"));
    }
  }

  /**update account table.
   * @parameter account
   *
   */
  @Override
  @Transactional
  public void updateAccount(Account account) throws HandleException {
    log.info(" in  updateAccount");

    if(account!=null)
    {
        Optional op;

        op = accountRepository.findByaccountId(account.getAccountId());
        if (op.isPresent())
        {
            account = accountRepository.saveAndFlush(account);

        } else {
    
                throw new HandleException(environment.getProperty("333"));
        }
    } else {
              throw new HandleException(environment.getProperty("7777"));
    }
  }

}
