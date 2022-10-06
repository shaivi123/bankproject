package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dao.RoleDao;
import com.spring.BankApplicatin.dto.userRequest;
import com.spring.BankApplicatin.entity.Role;
import com.spring.BankApplicatin.entity.User;
import com.spring.BankApplicatin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {


    @Autowired(required = false)
    private UserService userService;


    @PostMapping("/saveUser")
    public User createUser(@RequestBody userRequest dto) {
        return userService.createUser(dto.getFirstName(),dto.getLastName(),dto.getAge(),dto.getMail(),dto.getMobile(),dto.getPassword());
    }
    @GetMapping("/getUser")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/initRolesAndUser")
    public String initRolesAndUser(){
        userService.initRoleAndUser();
        return "update";
    }

    @PostMapping
    public User registerNewUser(@RequestBody User user) {
        return this.userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin() {
        return "This URL can only accessible by Admin";
    }

    @GetMapping("/forUser")
    public String forUser() {
        return "This URL will be accessible by User and Admin";
    }

}
