package com.spring.BankApplicatin.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawInput extends accountInput {

    long id;

    long amount;

}
