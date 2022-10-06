package com.spring.BankApplicatin.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class transactionInput {
    private long id;
    private String transactionName;
    private long balance;
}
