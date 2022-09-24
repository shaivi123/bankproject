package com.spring.BankApplicatin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts" )
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "acc_name")
    private String accName;
    @Column(name = "balance")
    private long balance;
    @ManyToOne
    @JoinColumn(name="users_id", nullable=false)
    private User users;



    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }

     public long withDraw (long amount){
        return balance;
     }


}
