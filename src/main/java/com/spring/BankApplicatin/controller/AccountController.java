package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.dto.DepositInput;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.spring.BankApplicatin.constants.constants.*;

@RestController
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;

    //for saving account details in userId
    @PostMapping("/saveAccount/{userId}")
    public Account createAccount(@RequestBody accountRequest dto) {
        return accountService.createAccount(dto.getAccName(), dto.getBalance(),dto.getUserID());
    }

    //for getting account list
    @GetMapping("/getAccount")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    //for checking balance
    @GetMapping("/getAccount/{accountId}")
    public Account checkBalanceById(@PathVariable Long accountId) {
        return accountService.checkBalanceById(accountId);
    }

    // for withdraw amount
    @PutMapping("/withdraw")
    public ResponseEntity<?> withDraw(@RequestBody WithdrawInput withdrawInput) {
        Account account = accountService.getAccount(withdrawInput.getId());
        if(account==null){
            return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        }else {
            accountService.isAmountAvailable(withdrawInput.getId(), account.getBalance());
            accountService.updateAccountBalance(account, withdrawInput.getBalance(), ACTION.WITHDRAW);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
    }
     // for deposit amount
    @PutMapping(value = "/deposit")
    public ResponseEntity<?> deposit(@RequestBody DepositInput depositInput) {
        Account account = accountService.getAccount(depositInput.getId());
        if (account == null) {
            return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        } else {
            accountService.updateAccountBalance(account, depositInput.getBalance(), ACTION.DEPOSIT);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
    }






}
