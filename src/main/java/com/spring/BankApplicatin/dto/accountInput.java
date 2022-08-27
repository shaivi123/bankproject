package com.spring.BankApplicatin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class accountInput {

        private long id;
        private String accNumber;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

}
