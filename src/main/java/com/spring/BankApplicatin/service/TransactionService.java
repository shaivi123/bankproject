package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.TransactionDao;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
     @Autowired
     private TransactionDao transactionDao;
     @Autowired
     private AccountService accountService;
     public Transaction saveTransaction(String accName,long balance ,long id){
//           Account account=new Account();
         Account account = accountService.findById(id);
         Transaction transaction=new Transaction();
         transaction.setAccName(accName);
         transaction.setBalance(balance);
//         transaction.setAccount(account );

       return transactionDao.save(transaction);
     }
}
