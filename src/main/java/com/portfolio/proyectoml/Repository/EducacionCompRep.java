
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.EducacionComp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionCompRep extends JpaRepository<EducacionComp, Integer>{
 
    Optional<EducacionComp> findByCurso(String curso);
    
    public boolean existsByCurso(String curso);
    
}
