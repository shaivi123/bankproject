package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.dao.AccountDao;
import com.spring.BankApplicatin.dao.TransactionDao;
import com.spring.BankApplicatin.dto.TransactionInput;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountDao accountDao;
    private final AccountService accountService;
    private final TransactionDao transactionDao;

    public boolean makeTransaction(TransactionInput transactionInput){

        String sourceAccountId = String.valueOf(transactionInput.getSourceAccount().getId());
        Optional<Account> sourceAccount = accountDao
                .findById(Long.parseLong(sourceAccountId));

        String targetAccountId = String.valueOf(transactionInput.getSourceAccount().getId());
        Optional<Account> targetAccount = accountDao.findById(Long.parseLong(sourceAccountId));


        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
            if (accountService.isAmountAvailable(transactionInput.getAmount(), sourceAccount.get().getBalance())) {
                var transaction = new Transaction();

                transaction.setAmount(transactionInput.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                accountService.updateAccountBalance(sourceAccount.get(), transactionInput.getAmount(), ACTION.WITHDRAW);
                transactionDao.save(transaction);

                return true;
            }
        }
        return false;
    }
}
