
package com.portfolio.proyectoml.Secure.Repositorio;

import com.portfolio.proyectoml.Secure.Entity.Role;
import com.portfolio.proyectoml.Secure.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
    
    Optional<Role> findByRolnombre(RolName rolnombre);
    
    
}
