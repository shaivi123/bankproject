package com.spring.BankApplicatin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts" )
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "acc_id")
    private long id;
    @Column(name = "acc_name")
    private String accName;
    @Column(name = "balance")
    private long balance;
//    @ManyToOne
//    @JoinColumn(name="users_id", nullable=false)
//    private User users;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @ManyToMany
    @JoinColumn(name = "user_id", nullable=false)
    private List<User> users;

//    public void setTransaction(List<Transaction> transaction) {
//        this.transaction = transaction;
//    }
//
//    public Account(List<Transaction> transaction) {
//        this.transaction = transaction;
//    }
//
//    public List<Transaction> getTransaction() {
//        return transaction;
//    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
//    private List<Transaction> transaction;



    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }

     public long withDraw (long amount){
        return balance;
     }


}
