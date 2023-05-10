
package com.portfolio.proyectoml.Secure.Repositorio;

import com.portfolio.proyectoml.Secure.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    
    Optional<User> findByNameUser(String nameUser);
    
    boolean existsByNameUser(String nameUser);
    
    boolean existsByEmail(String email);
    
}
