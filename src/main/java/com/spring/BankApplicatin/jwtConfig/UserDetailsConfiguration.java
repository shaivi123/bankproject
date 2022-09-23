package com.spring.BankApplicatin.jwtConfig;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.security.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailsConfiguration {

    private UserDao userDao;

    public UserDetailsConfiguration(UserDao userDao) {
        this.userDao = userDao;
    }

    @Bean(name = "userDetails")
    public UserDetailsService getUserDetailsService() {
        return new CustomUserDetailService(userDao);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
}
