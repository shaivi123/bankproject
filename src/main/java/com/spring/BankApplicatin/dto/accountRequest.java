package com.spring.BankApplicatin.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class accountRequest {

        private String accName;
        private long balance;
        private long userID;
}
