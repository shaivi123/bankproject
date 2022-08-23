package com.weetech.project.service;

import com.weetech.project.dao.AccountDao;
import com.weetech.project.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
