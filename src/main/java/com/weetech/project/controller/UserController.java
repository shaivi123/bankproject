package com.weetech.project.controller;

import com.weetech.project.dto.userRequest;
import com.weetech.project.entity.User;
import com.weetech.project.service.AccountService;
import com.weetech.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {


    @Autowired(required = false)
    private UserService userService;

    @PostMapping("/saveUser")
    public User createUser(@RequestBody userRequest dto) {
        return userService.createUser(dto.getFirstName(),dto.getLastName(),dto.getAge(),dto.getMail(),dto.getMobile());
    }
    @GetMapping("/getUser")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
