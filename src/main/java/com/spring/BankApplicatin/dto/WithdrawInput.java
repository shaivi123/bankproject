package com.spring.BankApplicatin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawInput extends accountInput{
             long id;

             @Positive(message = "Transfer amount must be positive")
             @Min(value = 1, message = "Amount must be larger than 1")
             long amount;

}
