package com.spring.BankApplicatin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    //@Notnull
    //@Size(min=2,max=30)
    @Column(name = "first_name")
    private String firstName;
    //@Size(min=2,max=30)
    @Column(name = "last_name")
    private String lastName;
    //@Size(min=1,max=2)
    @Column(name = "age")
    private int age;
    @Column(name = "mail")
    private String mail;
    @Column(name = "mobile")
    private long mobile;
    @Column(name = "password")
    private String password;
//    @OneToMany(mappedBy = "users")
//    //@JoinColumn(name = "id")
//    private List<Account> accounts;
//    public List<Account> getAccounts() {
//    return accounts;
//    }
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }

    @JsonIgnore
    @OneToMany
    private List<Account> accounts = new ArrayList<>();
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


//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//         Set<Authority> set=new HashSet<>();
//
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
}
