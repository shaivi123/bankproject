package com.spring.BankApplicatin.jwtConfig;

import com.spring.BankApplicatin.security.JwtAuthenticationEntryPoint;
import com.spring.BankApplicatin.security.JwtAuthenticationFilter;
import com.spring.BankApplicatin.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig  {

    @Autowired
     BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailService customUserDetailsService;
    @Autowired
    private JwtAuthenticationFilter jwtFilter;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired(required = false)
    private UserDetailsConfiguration userDetailsConfiguration;
    @Autowired
  //  @Qualifier("userDetails")
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      //  this code is used to roles only
//        http
//                .authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("ADMIN","MANAGER")
//                        .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","MANAGER")
//                        .antMatchers(HttpMethod.DELETE).hasAnyRole("MANAGER")
//                        .antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","MANAGER","USER");
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                //.antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    //New security config code
    @Bean(name= BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    public static final String[] ALLOWED_URLS = {
            "/h2-console/**",
            "/login",
            "/saveUser",
//            "/createFamilyAcc/{id}",
//            "/saveAccount/{user_id}",
//            "/addFamilyAcc/{user_id}/{id}",
//            "/findFamilyAccById/{id}",
//            "/createNewRole",
//            "/initRolesAndUser",
//            "/getUser",
//            "/getAccounts",
//            "/saveTransaction/{id}",
//            "/findTransactionById/{id}",
//            "/withdraw",
//            "/checkAccountById/{id}",
    };

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers(ALLOWED_URLS);
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.userDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }
}



