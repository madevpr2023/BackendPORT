
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRep extends JpaRepository<Proyectos, Integer>{
    
    Optional<Proyectos> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
}
