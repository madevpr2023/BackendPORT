
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.ProyectosDTO;
import com.portfolio.proyectoml.Model.Proyectos;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.ProyectosServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolioap-14eec.web.app", "http://localhost:4200"})
@RequestMapping("/Proyectos")
public class ProyectosController {
    
    @Autowired
    
    ProyectosServ proyservice;
    
    @GetMapping("/listadoproyectos")
    
    public ResponseEntity<List<Proyectos>> ListProyectos(){
    
        List<Proyectos> listado = proyservice.listaProyectos();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/proyectosdet/{id}")
    
    public ResponseEntity<Proyectos> ObtenertheId(@PathVariable("id") int id){
    
        if(!proyservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
            
        }
        
        Proyectos project = proyservice.ObtenerId(id).get();
        
        return new ResponseEntity(project, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarproyectos/{id}")
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!proyservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
            
        }
        
        proyservice.eliminarProyectos(id);
        
        return new ResponseEntity(new Message("Proyecto Eliminado exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/crearproyectos")
 
    public ResponseEntity<?> NuevoProyecto(@RequestBody ProyectosDTO dtopr){
    
        if(StringUtils.isBlank(dtopr.getNombre())){
            
            return new ResponseEntity(new Message("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        
              
        }
        
        if(proyservice.ExisteNombre(dtopr.getNombre())){
        
            return new ResponseEntity(new Message("El proyecto se encuentra registrado"), HttpStatus.BAD_REQUEST);
            
        }
        
        Proyectos project = new Proyectos(dtopr.getNombre(), dtopr.getDescripcion() ,dtopr.getLink(), dtopr.getImg());
        
        proyservice.guardarProyectos(project);
        
        return new ResponseEntity(new Message("Proyecto registrado"), HttpStatus.OK);
    }
    
    @PutMapping("/editarproyectos/{id}")
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody ProyectosDTO dtopr){
    
        
        if(!proyservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Proyecto no encontrado"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(proyservice.ExisteNombre(dtopr.getNombre()) && proyservice.Obtener(dtopr.getNombre()).get().getId() != id){
        
            return new ResponseEntity(new Message("Proyecto ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtopr.getNombre())){
        
            return new ResponseEntity(new Message("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        Proyectos proyectos = proyservice.ObtenerId(id).get();
        
        proyectos.setNombre(dtopr.getNombre());
        
        proyectos.setImg(dtopr.getImg());
        
        proyectos.setDescripcion(dtopr.getDescripcion());
        
        proyectos.setLink(dtopr.getLink());
        
        proyservice.guardarProyectos(proyectos);
        
        return new ResponseEntity(new Message("Proyecto Actualizado"), HttpStatus.OK);
        
        
    }
    
}
