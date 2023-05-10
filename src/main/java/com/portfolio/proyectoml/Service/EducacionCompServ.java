
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.EducacionComp;
import com.portfolio.proyectoml.Repository.EducacionCompRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class EducacionCompServ {
    
    @Autowired
    
    EducacionCompRep educationcomprep;
    
    public List<EducacionComp> listaEducacionComp(){
    
        return educationcomprep.findAll();
        
    }
    
    public Optional<EducacionComp> ObtenerId(int id){
    
        return educationcomprep.findById(id);
        
    }
    
    public Optional<EducacionComp> Obtener(String curso){
    
        return educationcomprep.findByCurso(curso);
        
    }
    
    public void guardarEducacionComp(EducacionComp educationcomp){
    
        educationcomprep.save(educationcomp);
        
    }
    
    public void eliminarEducacionComp(int id){
    
        educationcomprep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
        return educationcomprep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String curso){
    
        return educationcomprep.existsByCurso(curso);
        
        
    }
    
}
