
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.HardSkill;
import com.portfolio.proyectoml.Repository.HardSkillRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HardSkillServ {
    
    @Autowired
    
    HardSkillRep hsrep;
    
    public List<HardSkill> listaHardSkill(){
    
        return hsrep.findAll();
    }
    
    public Optional<HardSkill> ObtenerId(int id){
    
        return hsrep.findById(id);
        
    }
    
    public Optional<HardSkill> Obtener(String habilidad){
    
        return hsrep.findByHabilidad(habilidad);
        
    }
    
    public void guardarHardSkill(HardSkill hardskill){
    
        hsrep.save(hardskill);
        
    }
    
    public void eliminarHardSkill(int id){
    
        hsrep.deleteById(id);
    }
    
    public boolean ExisteId(int id){
    
        return hsrep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String habilidad){
    
        return hsrep.existsByHabilidad(habilidad);
        
    }
    
}
