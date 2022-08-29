package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.AccountDao;
import com.spring.BankApplicatin.dao.TransactionDao;
import com.spring.BankApplicatin.dto.TransactionInput;
import com.spring.BankApplicatin.entity.Account;
//import com.spring.BankApplicatin.entity.Accounts;
import com.spring.BankApplicatin.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountDao accountDao;
    private final AccountService accountService;
    private final TransactionDao transactionDao;
    // private final Account account;


    public Transaction saveTransaction(String accName, long amount) {
//         Account account=this.getById(id);
        Transaction transaction = new Transaction();
        transaction.setAccName(accName);
        transaction.setAmount(amount);
        // transaction.setAccount(account);
        // transaction.setId();

        return transactionDao.save(transaction);
        //new ResponseEntity<>(INVALID_TRANSACTION, HttpStatus.BAD_REQUEST);

    }

    public List<Transaction> getTransaction() {
        return transactionDao.findAll();
    }

    public Transaction getById(long id) {
        Optional<Transaction> transaction = transactionDao.findById(id);
        if (transaction.isPresent()) {
            return transaction.get();
        }else {
            return null;
        }
    }
}
//         transaction.orElse(null);
//     }


        //        int previousTransaction = 0;
//        if(previousTransaction >0){
//          // accountService.deposit(depositInput);
//            return new ResponseEntity<>(DEPOSIT, HttpStatus.OK);
//        }else if(previousTransaction <0){
//           // accountService.withDraw(withdrawInput);
//            return new ResponseEntity<>(WITHDRAW, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(INVALID_TRANSACTION, HttpStatus.BAD_REQUEST);
//        }
   // }























//    public boolean makeTransaction(TransactionInput transactionInput){
//
//        String sourceAccountId = String.valueOf(transactionInput.getSourceAccount().getId());
//        Optional<Account> sourceAccount = accountDao
//                .findById(Long.parseLong(sourceAccountId));
//
//        String targetAccountId = String.valueOf(transactionInput.getSourceAccount().getId());
//        Optional<Account> targetAccount = accountDao.findById(Long.parseLong(sourceAccountId));
//
//
//        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
//            //if (account.isAmountAvailable(transactionInput.getAmount(), sourceAccount.get().getBalance())) {
//                var transaction = new Transaction();
//
//                transaction.setAmount(transactionInput.getAmount());
//                transaction.setSourceAccountId(sourceAccount.get().getId());
//                transaction.setTargetAccountId(targetAccount.get().getId());
//                accountService.updateAccountBalance(sourceAccount.get(), transactionInput.getAmount(), ACTION.WITHDRAW);
//                transactionDao.save(transaction);
//
//                return true;
//            }
////        }
//        return false;
//    }

