
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.SoftSkill;
import com.portfolio.proyectoml.Repository.SoftSkillRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SoftSkillServ {
    
    @Autowired
    
    SoftSkillRep ssrep;
    
    public List<SoftSkill> listaSoftSkill(){
    
        return ssrep.findAll();
        
    }
    
    public Optional<SoftSkill> ObtenerId(int id){
    
        return ssrep.findById(id);
        
    }
    
    public Optional<SoftSkill> Obtener(String habilidad){
    
        return ssrep.findByHabilidad(habilidad);
        
    }
    
    public void guardarSoftSkill(SoftSkill softskill){
    
        ssrep.save(softskill);
    }
    
    public void eliminarSoftSkill(int id){
    
        ssrep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
        return ssrep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String habilidad){
    
        return ssrep.existsByHabilidad(habilidad);
        
    }
    
}
