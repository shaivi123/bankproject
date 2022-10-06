package com.spring.BankApplicatin.dao;

import com.spring.BankApplicatin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,String> {

}
