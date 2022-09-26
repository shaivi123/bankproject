package com.spring.BankApplicatin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class familyAccountRequest {

    private String accName;
    private long balance;
}
