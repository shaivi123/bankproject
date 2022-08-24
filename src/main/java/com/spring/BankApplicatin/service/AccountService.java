package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.dao.AccountDao;
import com.spring.BankApplicatin.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;

    public Account createAccount(String accName, long balance){
        Account account=new Account();
        account.setAccName(accName);
        account.setBalance(balance);
        return accountDao.save(account);
    }
    public List<Account> getAccounts(){
        return accountDao.findAll();
    }
    public Account checkBalanceById(long accountId){
        return accountDao.findById(accountId).get();
    }



    public Account getAccount(long id) {
        Optional<Account> account = accountDao
                .findById(id);

        return account.orElse(null);
    }

    public void updateAccountBalance(Account account, double amount, ACTION action) {
        if (action == ACTION.WITHDRAW) {
            account.setBalance((long) (account.getBalance() - amount));
        } else if (action == ACTION.DEPOSIT) {
            account.setBalance((long) (account.getBalance() + amount));
        }
        accountDao.save(account);
    }


    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }


}
