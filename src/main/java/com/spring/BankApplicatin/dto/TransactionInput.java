package com.spring.BankApplicatin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {

//    private  final AccountInput sourceAccount;

//    private final AccountInput targetAccount;
    private long id;
    private long amount;

//    private String reference;
    private accountInput sourceAccount;
    private accountInput targetAccount;


}
