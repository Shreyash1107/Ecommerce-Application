package com.apigateway.ApiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity httpSecurity){
        return httpSecurity.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers
                        (HttpMethod.POST,"/roles/saveRoles").permitAll().anyRequest().authenticated())
                .sessionManagement(session->session.
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

    }
    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig){
        return authConfig.getAuthenticationManager();
    }
}