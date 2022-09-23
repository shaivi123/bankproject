package com.spring.BankApplicatin.dao;


import com.spring.BankApplicatin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
public interface UserDao extends JpaRepository<User,Long> {
    Optional<User> findByMail(String userName);


//    @Query("")
//    public User getUserByUserName(){
//
//    }

}
