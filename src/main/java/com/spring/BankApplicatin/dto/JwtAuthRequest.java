package com.spring.BankApplicatin.dto;


import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtAuthRequest {
    private String username;
    private String password;

//    public JwtAuthRequest(String username, String password, ArrayList<Object> objects) {
//    }
}
