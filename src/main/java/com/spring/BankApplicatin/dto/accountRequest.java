package com.spring.BankApplicatin.dto;


import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class accountRequest {

        private String accName;
        private long balance;
}
