package com.spring.BankApplicatin;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BankApplicatinApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankApplicatinApplication.class, args);
		//System.out.println("enter something 123");
	}



	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
