package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.FamilyAccountDao;
import com.spring.BankApplicatin.dao.UserDao;
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
    public FamilyAcc createFamilyAccount(String accName, long balance, long userId) throws Exception {
        Set<User> user =Collections.singleton(userService.findById(userId));
        FamilyAcc familyAcc=new FamilyAcc();
        familyAcc.setAccName(accName);
        familyAcc.setBalance(balance);
        familyAcc.setUsers(user);
        return familyAccountDao.save(familyAcc);
    }
    public FamilyAcc addFamilyAccount(long id,long userId) throws Exception {
       User user=userDao.findById(userId).get();
       FamilyAcc familyAcc=familyAccountDao.findById(id).get();
       Set<User> acc=familyAcc.getUsers();
       acc.add(user);
       familyAcc.setUsers(acc);
       return familyAccountDao.save(familyAcc);
        //return null;
    }

    public Optional<FamilyAcc> findFamilyAccById(long id) {

        return familyAccountDao.findById(id);
    }
}


