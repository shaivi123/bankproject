package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.constants.Constants;
import com.spring.BankApplicatin.dao.AccountDao;
import com.spring.BankApplicatin.dto.DepositInput;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.spring.BankApplicatin.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;
    private final UserService userService;

    public Account createAccount(String accName, long balance, long userId) throws IOException {
        User userExists = userService.findById(userId);
        Account account = new Account();
        account.setAccName(accName);
        account.setBalance(balance);
        // account.setUser(userExists);
        return accountDao.save(account);
    }

    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    public Account checkBalanceById(long accountId) {
        return accountDao.findById(accountId).get();
    }


    public Account getAccount(long id) {
        Optional<Account> account = accountDao
                .findById(id);
        // accountDao.save(account);
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

    public ResponseEntity<?> withDraw(WithdrawInput withdrawInput) {
        Account account = getAccount(withdrawInput.getId());
        if (account == null) {
             return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        } else {
            if (account.isAmountAvailable(withdrawInput.getAmount(), account.getBalance())) {
                updateAccountBalance(account, withdrawInput.getAmount(), ACTION.WITHDRAW);
                return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
            } else {
                 return new ResponseEntity<>(INSUFFICIENT_ACCOUNT_BALANCE, HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<?> deposit(DepositInput depositInput){
        Account account = getAccount(depositInput.getId());
        if (account == null) {
            return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        } else {
            updateAccountBalance(account, depositInput.getAmount(), ACTION.DEPOSIT);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
    }
}