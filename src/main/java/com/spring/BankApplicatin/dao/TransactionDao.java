package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TransactionDao extends JpaRepository<Transaction,Long> {
}
