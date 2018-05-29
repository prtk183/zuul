package com.szuul.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.szuul.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

  @Query
  Optional<Account> findByaccountId(Long accountId);

}
