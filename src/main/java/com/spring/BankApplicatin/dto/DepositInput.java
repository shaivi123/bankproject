package com.spring.BankApplicatin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositInput {
    private long id;
    //private long targetAccountNo;
    private long balance;
}
