
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.Persona;
import com.portfolio.proyectoml.Repository.PersonaRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class PersonaServ {
    
    @Autowired
    
    PersonaRep personrep;
    
    public List<Persona> ListaPersona(){
    
        return personrep.findAll();
        
    }
    
    public Optional<Persona> ObtenerId(int id){
    
       return personrep.findById(id);
        
    }
    
    public Optional<Persona> Obtener(String nombre){
    
        return personrep.findByNombre(nombre);
        
    }
    
    public void CrearPersona(Persona persona){
    
        personrep.save(persona);
        
    }
    
    public void EliminarPersona(int id){
    
        personrep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
        return personrep.existsById(id);
            
    }
    
    public boolean ExisteNombre(String nombre){
    
        return personrep.existsByNombre(nombre);
        
    }
        
        
        
    
    
    
}
