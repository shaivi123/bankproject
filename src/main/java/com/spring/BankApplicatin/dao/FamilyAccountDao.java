package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.FamilyAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyAccountDao extends JpaRepository<FamilyAcc,Long> {
}
