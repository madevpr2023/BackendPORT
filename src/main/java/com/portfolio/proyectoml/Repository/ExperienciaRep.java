
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRep extends JpaRepository<Experiencia, Integer>{
    
    Optional<Experiencia> findByPuesto(String puesto);
    
    public boolean existsByPuesto(String puesto);
    
}
