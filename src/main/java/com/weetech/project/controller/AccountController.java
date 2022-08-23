package com.weetech.project.controller;


import com.weetech.project.entity.Account;
import com.weetech.project.service.AccountService;
import com.weetech.project.dto.accountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;


    @PostMapping("/saveAccount")
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

}


