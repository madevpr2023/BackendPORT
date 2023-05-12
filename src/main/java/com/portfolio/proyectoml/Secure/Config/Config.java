
package com.portfolio.proyectoml.Secure.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
    
    @Bean
    
    public AuthenticationManager authmanager(AuthenticationConfiguration authconfig) throws Exception {

        return authconfig.getAuthenticationManager();

    }
    
    @Bean
    
    public PasswordEncoder passencoder(){
    
        return new BCryptPasswordEncoder();
        
    }
    

}
