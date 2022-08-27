package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<Transaction,Long> {
}
