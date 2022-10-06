package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.transactionInput;
import com.spring.BankApplicatin.entity.Transaction;
import com.spring.BankApplicatin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/saveTransaction/{id}")
    public Transaction saveTransaction(@RequestBody transactionInput dto, @PathVariable int id){

        return transactionService.saveTransaction(dto.getId(),dto.getTransactionName(),dto.getBalance(),id);
    }
    @GetMapping("/findTransactionById/{id}")
    public Optional<Transaction> findTransactionById(@PathVariable long id){
        return transactionService.findTransactionById(id);
    }

}
