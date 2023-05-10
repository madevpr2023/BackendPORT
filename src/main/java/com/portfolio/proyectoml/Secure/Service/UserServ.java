
package com.portfolio.proyectoml.Secure.Service;

import com.portfolio.proyectoml.Secure.Entity.User;
import com.portfolio.proyectoml.Secure.Repositorio.UserRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServ {
    
    @Autowired
    
    UserRepo userrepos;
    
    public Optional<User> getByNameUser(String nameUser){
    
        return userrepos.findByNameUser(nameUser);
    }
    
    
    public boolean existsByNameUser(String nameUser){
    
        return userrepos.existsByNameUser(nameUser);
        
    }
    
    public boolean existsByEmail(String email){
    
        return userrepos.existsByEmail(email);
        
    }
    
    public void guardarUsuario(User usuario){
    
        userrepos.save(usuario);
        
    }
    
}
