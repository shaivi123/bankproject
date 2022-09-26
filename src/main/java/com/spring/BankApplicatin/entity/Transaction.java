package com.spring.BankApplicatin.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private long balance;
    private String accName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "acc_id",nullable = false)
    private Account account;
}
