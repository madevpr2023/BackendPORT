
package com.portfolio.proyectoml.Secure;

import com.portfolio.proyectoml.Secure.JWT.JwtEntryPoint;
import com.portfolio.proyectoml.Secure.JWT.JwtFilter;
import com.portfolio.proyectoml.Secure.Service.UserDetailsIm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)

public class MainSecurity{
    
    @Autowired
    
    UserDetailsIm userdetim; 
    
    @Autowired
    
    JwtEntryPoint jwtentpoint;
    
    AuthenticationManager authmanager;
   
    @Autowired
    
    PasswordEncoder passencoder;
   
    @Bean
    
    public JwtFilter jwtfilter(){
    
        return new JwtFilter();
        
    }
    
    
    @Bean 
    
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        
        AuthenticationManagerBuilder authmanagerbuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authmanagerbuilder.userDetailsService(userdetim).passwordEncoder(passencoder);
   
        authmanager = authmanagerbuilder.build();
        
        http.authenticationManager(authmanager);
        
        http.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtentpoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtfilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
   
    
    
}
