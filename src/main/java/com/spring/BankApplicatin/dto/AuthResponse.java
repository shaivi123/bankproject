package com.spring.BankApplicatin.dto;


import com.spring.BankApplicatin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {

    private User user;
    private String accessToken;
}
