package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountDao extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {
   // List<Account> findByAccountName(String lastname);
//    @Query("SELECT a FROM Account a WHERE CONCAT(a.accName) LIKE %?1%")
//    public List<Account> findByAccName(@Param("keyword") String keyword);

}
