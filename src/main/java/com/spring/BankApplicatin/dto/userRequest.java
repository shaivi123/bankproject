package com.spring.BankApplicatin.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String mail;
    private long mobile;

}
