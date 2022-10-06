package com.spring.BankApplicatin.dao;


import com.spring.BankApplicatin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
public interface UserDao extends JpaRepository<User,Long> {

    //this method is used to userName
    Optional<User> findByMail(String mail);
   // @Query("select u from User where u.mail=: mail")
    @Query("SELECT a FROM User a WHERE CONCAT(a.mail) LIKE %?1%")
    public User getUserByUserName(@Param("mail") String mail);

}
