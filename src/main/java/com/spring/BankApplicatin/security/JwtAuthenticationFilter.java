package com.spring.BankApplicatin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
      @Autowired
      private CustomUserDetailService customUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String requestTokenHeader=request.getHeader("Authorization");
            System.out.println(requestTokenHeader);

            String username=null;
            String token=null;
            if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {
                token = requestTokenHeader.substring(7);
                try {
                    username = this.jwtTokenHelper.getUsernameFromToken(token);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Enable to get JWT token !!");
                }

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                    if (this.jwtTokenHelper.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    } else {
                        System.out.println("Invalid JWT token !!");
                    }
                } else {
                    System.out.println("Token is not validated");
                }
            }
               filterChain.doFilter(request,response);
    }
}
