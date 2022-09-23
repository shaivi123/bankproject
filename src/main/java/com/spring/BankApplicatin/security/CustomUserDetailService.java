package com.spring.BankApplicatin.security;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.dto.JwtAuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired(required = false)
    private JwtAuthRequest jwtAuthRequest;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public CustomUserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        com.spring.BankApplicatin.entity.User user = userDao.findByMail(userName).orElseThrow(() -> new BadCredentialsException("bad credential"));
//        return new org.springframework.security.core.userdetails.User(user.getMail(),user.getPassword(),new ArrayList<>());

        if(userName.equals("shaivi")){

            return  new User("shaivi","parmar@",new ArrayList<>());

        }else{
            throw new UsernameNotFoundException("User name not found !! ");
        }
    }
}
