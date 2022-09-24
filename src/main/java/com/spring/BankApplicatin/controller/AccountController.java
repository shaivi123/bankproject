package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.DepositInput;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;

    //for saving account details in userId
    @PostMapping("/saveAccount")
    public Account createAccount(@RequestBody accountRequest dto) throws Exception {
        return accountService.createAccount(dto.getAccName(), dto.getBalance());
    }

    //for getting account list
    @GetMapping("/getAccounts")
    public List<Account> getAccounts(@RequestParam("accName") String accName) {
        return accountService.getAccounts(accName);
    }

    //for checking balance
    @GetMapping("/checkAccountById/{id}")
    public Optional<Account> checkAccountById(@PathVariable long id) {
        return accountService.checkAccountById(id);
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
     @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Account> getPagination(@PathVariable int offset, @PathVariable int pageSize){
      Page<Account> findPagination=accountService.findAccountWithPagination(offset -1,pageSize);
      return findPagination;
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
