package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.dao.UserDao;
import com.spring.BankApplicatin.dto.JwtAuthRequest;
import com.spring.BankApplicatin.dto.AuthResponse;
import com.spring.BankApplicatin.entity.User;
import com.spring.BankApplicatin.security.CustomUserDetailService;
import com.spring.BankApplicatin.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
   @Autowired
   private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
   // @Qualifier("userDetails")
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private UserDao userDao;

    public AuthResponse createAccessToken(JwtAuthRequest authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();
        authenticate(username, password);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String accessToken = jwtTokenHelper.generateToken(username);
        User user = userDao.findById(Long.valueOf(username)).get();
        return new AuthResponse(user, accessToken);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password ));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials");
        }
    }



























//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName() + "";
//        String password = authentication.getCredentials() + "";
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        if (userDetails == null) {
//            throw  new BadCredentialsException("Bad Credentials!");
//        }
//        if (bCryptPasswordEncoder.matches(password,userDetails.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(username, null, null);
//        } else {
//            throw new BadCredentialsException("Bad Credentials!");
//        }
//    }


}
