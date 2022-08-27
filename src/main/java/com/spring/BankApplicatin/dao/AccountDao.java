package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends JpaRepository<Account,Long> {
   // Optional<Account> findBySortCodeAndAccountNumber(String sortCode, String accountNumber);
//    Optional<Account> findByAccountNumber(String accountNumber);

   // Object findBySourceAccountIdOrderByInitiationDate(long id);
   Optional<Account> findById(long sourceAccountId);
}
