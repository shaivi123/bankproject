package com.spring.BankApplicatin.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private String accName;
    private long amount;
    private long accountId;
}
