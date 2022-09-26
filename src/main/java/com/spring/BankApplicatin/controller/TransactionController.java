package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Transaction;
import com.spring.BankApplicatin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction saveTransaction(@RequestBody accountRequest dto,@PathVariable("id") int id){

        return transactionService.saveTransaction(dto.getAccName(),dto.getBalance(),id);
    }

}
