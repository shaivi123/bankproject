package com.spring.BankApplicatin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users" )
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
    @Column(name = "mail")
    private String mail;
    @Column(name = "mobile")
    private long mobile;
    @Column(name = "password")
    private String password;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="USER_ROLE",
                   joinColumns = {@
                           JoinColumn(name = "user_id")
                   },
                  inverseJoinColumns = {@JoinColumn(name = "role_id")
                  })
    private Set<Role> roles=new HashSet<>();


    @JsonIgnore
    @OneToMany
    private List<Account> accounts ;
    @JsonIgnore
    @ManyToMany
    private List<FamilyAcc> familyAccs=new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", mobile=" + mobile +
                ", password='" + password + '\'' +
                ", familyAccs=" + familyAccs +
                '}';
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }
    @JsonIgnore
    @Override
    public String getUsername() {
        return this.mail;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }

}
