package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



//    public User findById(long id) {
//        Optional<User> user = userDao
//                .findById(id);
//        // accountDao.save(account);
//        return user.orElse(null);
//       // return null;
//    }
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

}
