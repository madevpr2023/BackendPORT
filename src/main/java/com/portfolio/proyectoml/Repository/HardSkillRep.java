
package com.portfolio.proyectoml.Repository;

import com.portfolio.proyectoml.Model.HardSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRep extends JpaRepository<HardSkill, Integer>{
    
    Optional<HardSkill> findByHabilidad(String habilidad);
    
    public boolean existsByHabilidad(String habilidad);
    
}
