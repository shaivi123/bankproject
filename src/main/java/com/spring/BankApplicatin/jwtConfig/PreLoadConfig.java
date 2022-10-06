package com.spring.BankApplicatin.jwtConfig;


import com.spring.BankApplicatin.dao.RoleDao;
import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.Role;
import com.spring.BankApplicatin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class PreLoadConfig {
     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public CommandLineRunner preload(RoleDao roleDao, UserDao userDao) {
        return args -> {

            Role adminRole =new Role();
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin role");
            roleDao.save(adminRole);

            Role userRole =new Role();
            userRole.setRoleName("USER");
            userRole.setRoleDescription("Default role for newly created  record ");
            roleDao.save(userRole);


            User adminUser = new User();
            adminUser.setFirstName("jay");
            adminUser.setLastName("bhanushali");
            adminUser.setAge(40);
            adminUser.setMail("jay@gmail.com");
            adminUser.setMobile(74776367);
            adminUser.setPassword(bCryptPasswordEncoder.encode("jay@123"));
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminUser.setRoles(adminRoles);
            userDao.save(adminUser);
        };
    }
}
