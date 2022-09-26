package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.familyAccountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.FamilyAcc;
import com.spring.BankApplicatin.service.FamilyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyAccountController {
    @Autowired
    private FamilyAccountService familyAccountService;
    @PostMapping("/createFamilyAcc/{user_id}")
    public FamilyAcc createFamilyAccount(@RequestBody familyAccountRequest dto, @PathVariable("user_id") long userId){
        try {
            return familyAccountService.createFamilyAccount(dto.getAccName(),dto.getBalance(),userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/addFamilyAcc/{user_id}/{id}")
    public FamilyAcc addFamilyAccount(@RequestBody familyAccountRequest dto, @PathVariable("user_id") long userId){

        try {
            return familyAccountService.addFamilyAccount(dto.getAccName(),dto.getBalance(),userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
