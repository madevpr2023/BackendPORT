
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.Educacion;
import com.portfolio.proyectoml.Repository.EducacionRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionServ {
    
    @Autowired
    
    EducacionRep educationrep;
    
    public List<Educacion> listaEducacion(){
    
        return educationrep.findAll();
        
    }
    
    public Optional<Educacion> ObtenerId(int id){
    
        return educationrep.findById(id);
        
    }
    
    public Optional<Educacion> Obtener(String institucion){
    
        return educationrep.findByInstitucion(institucion);
        
    }
    
    public void guardarEducacion(Educacion education){
    
        educationrep.save(education);
        
    }
    
    public void eliminarEducacion(int id){
    
        educationrep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
       return educationrep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String institucion){
    
       return educationrep.existsByInstitucion(institucion);
        
    }
    
    
    
    
}
