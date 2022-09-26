package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.FamilyAccountDao;
import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.FamilyAcc;
import com.spring.BankApplicatin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
public class FamilyAccountService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
   private FamilyAccountDao familyAccountDao;
    public FamilyAcc
    createFamilyAccount(String accName, long balance, long userId) throws Exception {
        Set<User> user =Collections.singleton(userService.findById(userId));
        //Account account = new Account();
        FamilyAcc familyAcc=new FamilyAcc();
        familyAcc.setAccName(accName);
        familyAcc.setBalance(balance);
        familyAcc.setUsers(user);
        return familyAccountDao.save(familyAcc);
    }

    public FamilyAcc addFamilyAccount(String accName,long balance,long userId) throws Exception {
//        Set<User> user =new HashSet<>();
//        Optional<User> users=userDao.findById(userId);
//        Set<User> users = null;
////        FamilyAcc familyAccount = familyAccountDao.findById(id).get();
//        User user = userDao.findById(userId).get();
//        users = familyAccount.getUsers();
//        users.add(user);
//        familyAccount.setUsers(users);
//        users.
        return null;
    }

}
