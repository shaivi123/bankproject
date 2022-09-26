package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.FamilyAcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyAccountDao extends JpaRepository<FamilyAcc,Long> {
}
