package com.spring.BankApplicatin.controller;

import com.spring.BankApplicatin.dto.JwtAuthRequest;
import com.spring.BankApplicatin.security.CustomUserDetailService;
import com.spring.BankApplicatin.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenerateTokenController {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public String createToken(@RequestBody JwtAuthRequest dto )throws Exception{
         try {
             authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
         }catch(Exception e){
             throw new Exception("invalid username/password");
         }
       return jwtTokenHelper.generateToken(dto.getUsername());
    }
    @GetMapping("/welcome")
    public String welcome(){
        String text="this is private page";
        text+="this page is not allow to unauthenticated users";
        return text;
    }















//    @PostMapping("/token")
//    public ResponseEntity<?> generateToken(@RequestBody jwtRequest dto) throws Exception {
//        //System.out.println(jwtReq);
//        System.out.println("31========");
//        try{
//            System.out.println("33=======");
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
//            System.out.println("35==========");
//        }catch(UsernameNotFoundException e){
//            e.printStackTrace();
//            throw new Exception("Bad credentials");
//        }catch(BadCredentialsException ex){
//            ex.printStackTrace();
//            throw new Exception("Bad credentials");
//        }
//        System.out.println("41========");
//        UserDetails userDetails=this.customUserDetailService.loadUserByUsername(dto.getUsername());
//        System.out.println("43==========");
//        String token=jwtTokenHelper.generateToken(userDetails);
//        System.out.println("45=======");
//        System.out.println("JWT "+token);
//        System.out.println("47===========");
//        return ResponseEntity.ok(new jwtResponse(token));
//    }

}
