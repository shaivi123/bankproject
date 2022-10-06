package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.familyAccountRequest;
import com.spring.BankApplicatin.entity.FamilyAcc;
import com.spring.BankApplicatin.service.FamilyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/addFamilyAcc/{userId}/{id}")
    public FamilyAcc addFamilyAccount(@PathVariable long id, @PathVariable long userId){

        try {
            return familyAccountService.addFamilyAccount(id,userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/findFamilyAccById/{id}")
    public Optional<FamilyAcc> findFamilyAccById(@PathVariable long id){
       return familyAccountService.findFamilyAccById(id);
    }
}
