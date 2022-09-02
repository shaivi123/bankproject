package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.userRequest;
import com.spring.BankApplicatin.entity.User;
import com.spring.BankApplicatin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @PostMapping("/saveUser")
    public User createUser( @RequestBody userRequest dto) {
        return userService.createUser(dto.getFirstName(),dto.getLastName(),dto.getAge(),dto.getMail(),dto.getMobile());
    }
    @GetMapping("/getUser")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
