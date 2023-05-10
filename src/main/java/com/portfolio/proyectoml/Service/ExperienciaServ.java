
package com.portfolio.proyectoml.Service;


import com.portfolio.proyectoml.Model.Experiencia;
import com.portfolio.proyectoml.Repository.ExperienciaRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaServ {
    
    @Autowired
    
    ExperienciaRep experiencerep;
    
    public List<Experiencia> listaExperiencia(){
    
        return experiencerep.findAll();
        
    }
    
    public Optional<Experiencia> ObtenerId(int id){
    
        return experiencerep.findById(id);
        
    }
    
    public Optional<Experiencia> Obtener(String puesto){
    
        return experiencerep.findByPuesto(puesto);
        
    }
    
    public void guardarExperiencia(Experiencia exp){
    
        experiencerep.save(exp);
        
    }
    
    public void eliminarExperiencia(int id){
    
        experiencerep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
        return experiencerep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String curso){
    
        return experiencerep.existsByPuesto(curso);
        
    }
    
}
