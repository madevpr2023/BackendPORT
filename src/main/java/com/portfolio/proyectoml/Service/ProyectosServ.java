
package com.portfolio.proyectoml.Service;

import com.portfolio.proyectoml.Model.Proyectos;
import com.portfolio.proyectoml.Repository.ProyectosRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectosServ {
    
    @Autowired
    
    ProyectosRep proyrep;
    
    public List<Proyectos> listaProyectos(){
    
        return proyrep.findAll();
    }
    
    public Optional<Proyectos> ObtenerId(int id){
    
        return proyrep.findById(id);
        
    }
    
    public Optional<Proyectos> Obtener(String nombre){
    
        return proyrep.findByNombre(nombre);
        
    }
    
    public void guardarProyectos(Proyectos proyecto){

        proyrep.save(proyecto);
        
    }
    
    public void eliminarProyectos(int id){
    
        proyrep.deleteById(id);
        
    }
    
    public boolean ExisteId(int id){
    
        return proyrep.existsById(id);
        
    }
    
    public boolean ExisteNombre(String nombre){
    
        return proyrep.existsByNombre(nombre);
        
    }
    
    
}
