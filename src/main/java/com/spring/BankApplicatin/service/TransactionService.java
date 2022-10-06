package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.TransactionDao;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
     @Autowired
     private TransactionDao transactionDao;
     @Autowired
     private AccountService accountService;
     public Transaction saveTransaction(long id, String transactionName,long balance ,long accId){
//           Account account=new Account();
         Account account = accountService.findById(accId);
         Transaction transaction=new Transaction();
         transaction.setTransactionId(id);
         transaction.setTransactionName(transactionName);
         transaction.setBalance(balance);
         transaction.setAccount(account );

       return transactionDao.save(transaction);
     }

    public Optional<Transaction> findTransactionById(long id) {
         return transactionDao.findById(id);
    }
}
