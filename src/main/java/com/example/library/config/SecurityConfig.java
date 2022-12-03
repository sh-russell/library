package com.example.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(customizer -> {
                    customizer.antMatchers("/auth/login", "/auth/sign-up", "/webjars/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(customizer -> {
                    customizer
                            .loginPage("/auth/login")
                            .usernameParameter("email")
                            .defaultSuccessUrl("/books");
                })
                .logout(customizer ->{
                    customizer.logoutUrl("/auth/logout")
                            .clearAuthentication(true)
                            .logoutSuccessUrl("/auth/login");
                })
                .userDetailsService(userDetailsService).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
