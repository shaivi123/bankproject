package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.RoleDao;
import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
      @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleService roleService;

    public User createUser(String firstName, String lastName, int age, String mail, long mobile,String password){

        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setMail(mail);
        user.setMobile(mobile);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userDao.save(user);
    }
    public List<User> getUsers(){
        return userDao.findAll();
    }


 public User findById(long userId) throws Exception
{
    Optional<User> byId = userDao.findById(userId);
    if(byId.isPresent())
    {
        return byId.get();
    }else{
        throw new RuntimeException("User not found!");
    }
}

    public String initRoleAndUser(){

        return "update";
    }

    public User registerNewUser(User user) {
        return userDao.save(user);
    }



}
