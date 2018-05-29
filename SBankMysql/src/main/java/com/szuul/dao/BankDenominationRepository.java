package com.szuul.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szuul.model.Bank_Denomination;
import com.szuul.wrappers.WrapperRequestObject;

public interface BankDenominationRepository extends JpaRepository<Bank_Denomination, Long>{



}
