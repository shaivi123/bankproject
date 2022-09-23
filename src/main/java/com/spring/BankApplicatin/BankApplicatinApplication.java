package com.spring.BankApplicatin;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BankApplicatinApplication implements CommandLineRunner {
   @Autowired
   private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankApplicatinApplication.class, args);
		//System.out.println("enter something 123");
	}

	@Override
	public void run(String... args) throws Exception {
      System.out.println(this.passwordEncoder.encode("admin"));
	}


//	@Bean
//	PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

}
