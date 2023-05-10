
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRep extends JpaRepository<Educacion, Integer>{
    
    Optional<Educacion> findByInstitucion(String institucion);
    
    public boolean existsByInstitucion(String institucion);
    
}
