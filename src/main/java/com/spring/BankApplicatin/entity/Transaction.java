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
    private String transactionName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "acc_id",nullable = false)
    private Account account;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", balance=" + balance +
                ", transactionName='" + transactionName + '\'' +
                ", account=" + account +
                '}';
    }
}
