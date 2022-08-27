package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.DepositInput;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;

    //for saving account details in userId
    @PostMapping("/saveAccount/{userId}")
    public Account createAccount(@RequestBody accountRequest dto) throws IOException {
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
    public ResponseEntity<?> withDraw( @Valid @RequestBody WithdrawInput withdrawInput) {
        return accountService.withDraw(withdrawInput);
        }

     // for deposit amount
    @PutMapping(value = "/deposit")
    public ResponseEntity<?> deposit( @Valid @RequestBody DepositInput depositInput) {
          return accountService.deposit(depositInput);
    }














//    @PostMapping(value = "/transactions")
//    public ResponseEntity<?> makeTransfer(@RequestBody TransactionInput transactionInput) {
//       if (InputValidator.isSearchTransactionValid(transactionInput)) {
////            new Thread(() -> transactionService.makeTransfer(transactionInput));
//            boolean isComplete = accountService.makeTransfer(transactionInput);
//            return new ResponseEntity<>(isComplete, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(INVALID_TRANSACTION, HttpStatus.BAD_REQUEST);
//        }
//    }
}
