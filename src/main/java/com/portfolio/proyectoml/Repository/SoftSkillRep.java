
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRep extends JpaRepository<SoftSkill, Integer>{
    
    Optional<SoftSkill> findByHabilidad(String habilidad);
    
    public boolean existsByHabilidad(String habilidad);
    
}
