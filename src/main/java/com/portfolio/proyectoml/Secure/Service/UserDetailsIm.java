
package com.portfolio.proyectoml.Secure.Service;

import com.portfolio.proyectoml.Secure.Entity.User;
import com.portfolio.proyectoml.Secure.Entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsIm implements UserDetailsService{
    
    @Autowired
    
    UserServ userserv;

    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
       
        User usuario = userserv.getByNameUser(nameUser).get();
        
        return UserPrincipal.build(usuario);
    }
    
    
    
    
    
    
}
