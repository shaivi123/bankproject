package com.spring.BankApplicatin.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "familyAccount" )
public class FamilyAcc {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "acc_name")
    private String accName;
    @Column(name = "balance")
    private long balance;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    @ManyToMany
    @JoinColumn(name = "user_id")
    private Set<User> users;
}
