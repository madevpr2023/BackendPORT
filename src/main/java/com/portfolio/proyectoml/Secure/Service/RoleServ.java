
package com.portfolio.proyectoml.Secure.Service;

import com.portfolio.proyectoml.Secure.Entity.Role;
import com.portfolio.proyectoml.Secure.Enums.RolName;
import com.portfolio.proyectoml.Secure.Repositorio.RoleRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServ {
    
    @Autowired
    
    RoleRepo rolerepos;
    
    public Optional<Role> getByRoleName(RolName rolnombre){
    
        return rolerepos.findByRolnombre(rolnombre);
        
    }
    
    public void guardarRoleUser(Role role){
    
        rolerepos.save(role);
        
    }
    
}
