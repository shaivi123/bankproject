package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User createUser(String firstName, String lastName, int age, String mail, long mobile){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setMail(mail);
        user.setMobile(mobile);
        return userDao.save(user);
    }
    public List<User> getUsers(){
        return userDao.findAll();
    }
}
