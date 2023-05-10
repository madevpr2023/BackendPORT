
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRep extends JpaRepository<Persona, Integer>{
    
    public Optional<Persona> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
}
