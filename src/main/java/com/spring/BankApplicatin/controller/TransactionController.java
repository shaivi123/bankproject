package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.TransactionInput;
import com.spring.BankApplicatin.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

     @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transactions")
    public ResponseEntity<?> makeTransfer(
            @Valid @RequestBody TransactionInput transactionInput) {
//        if (InputValidator.isSearchTransactionValid(transactionInput)) {
//            new Thread(() -> transactionService.makeTransfer(transactionInput));
            boolean isComplete = transactionService.makeTransaction(transactionInput);
            return new ResponseEntity<>(isComplete, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(INVALID_TRANSACTION, HttpStatus.BAD_REQUEST);
//        }
    }
}
