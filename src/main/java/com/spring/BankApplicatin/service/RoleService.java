package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.RoleDao;
import com.spring.BankApplicatin.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
      return roleDao.save(role);
    }

}
