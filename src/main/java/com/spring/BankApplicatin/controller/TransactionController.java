package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.TransactionInput;
import com.spring.BankApplicatin.entity.Transaction;
import com.spring.BankApplicatin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {

     @Autowired
    private TransactionService transactionService;
    @PostMapping(value = "/transactions")
     public Transaction saveTransaction(@Valid @RequestBody TransactionInput transactionInput){
         return transactionService.saveTransaction(transactionInput.getAccName(),transactionInput.getAmount());
     }
      @GetMapping(value = "/GetTransactions")
     public List<Transaction> getTransaction(@Valid @RequestBody TransactionInput transactionInput){
        return transactionService.getTransaction();
     }
}









