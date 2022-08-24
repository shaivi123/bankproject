package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;

//    @GetMapping("/getAc")
//    public String getAccount(){
//        System.out.println("hhh");
//        return "welcome";
//    }

    @PostMapping("/saveAccount/{userId}")
    public Account createAccount(@RequestBody accountRequest dto){
        return accountService.createAccount(dto.getAccName(),dto.getBalance());
    }
    @GetMapping("/getAccount")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/getAccount/{accountId}")
    public Account checkBalanceById(@PathVariable Long accountId){
        return accountService.checkBalanceById(accountId);
    }

    @PutMapping("/withdraw/{accountId}")
    public void withDraw(@RequestBody WithdrawInput withdrawInput) {
        Account account = accountService.getAccount(withdrawInput.getId());
        accountService.isAmountAvailable(withdrawInput.getId(), account.getBalance());
        accountService.updateAccountBalance(account, withdrawInput.getAmount(), ACTION.WITHDRAW);
    }

}
