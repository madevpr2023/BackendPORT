
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.ExperienciaDTO;
import com.portfolio.proyectoml.Model.Experiencia;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.ExperienciaServ;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Experiencia")
public class ExperienciaController {
    
    @Autowired
    
    ExperienciaServ experienceservice;
    
    @GetMapping("/listadoexperiencia")
    
    public ResponseEntity<List<Experiencia>> ListExp(){
    
        List<Experiencia> listado = experienceservice.listaExperiencia();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/experienciadet/{id}")
    
    public ResponseEntity<Experiencia> ObtenertheId(@PathVariable("id") int id){
    
        if(!experienceservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Experiencia no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        Experiencia experience = experienceservice.ObtenerId(id).get();
        
        return new ResponseEntity(experience, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarexperiencia/{id}")
   
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!experienceservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Experiencia no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        experienceservice.eliminarExperiencia(id);
        
        return new ResponseEntity(new Message("Experiencia Eliminada exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/crearexperiencia")
    
    
    public ResponseEntity<?> NuevaExperiencia(@RequestBody ExperienciaDTO dtoexp){
    
        if(StringUtils.isBlank(dtoexp.getPuesto())){
            
            return new ResponseEntity(new Message("Puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        
              
        }
        
        if(experienceservice.ExisteNombre(dtoexp.getPuesto())){
        
            return new ResponseEntity(new Message("La experiencia se encuentra registrada"), HttpStatus.BAD_REQUEST);
            
        }
        
        Experiencia experience = new Experiencia(dtoexp.getEmpresa(), dtoexp.getPuesto(), dtoexp.getAnioInicio(), dtoexp.getAnioFin(), dtoexp.getDescripcion());
        
        experienceservice.guardarExperiencia(experience);
        
        return new ResponseEntity(new Message("Experiencia registrada"), HttpStatus.OK);
    }
    
    @PutMapping("/editarexperiencia/{id}")
   
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody ExperienciaDTO dtoexp){
    
        
        if(!experienceservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Experiencia no encontrada"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(experienceservice.ExisteNombre(dtoexp.getPuesto()) && experienceservice.Obtener(dtoexp.getPuesto()).get().getId()!= id){
        
            return new ResponseEntity(new Message("Experiencia ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtoexp.getPuesto())){
        
            return new ResponseEntity(new Message("El puesto de trabajo es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        Experiencia experiencia = experienceservice.ObtenerId(id).get();
        
        experiencia.setEmpresa(dtoexp.getEmpresa());
        
        experiencia.setPuesto(dtoexp.getPuesto());
        
        experiencia.setAnioInicio(dtoexp.getAnioInicio());
        
        experiencia.setAnioFin(dtoexp.getAnioFin());

        experiencia.setDescripcion(dtoexp.getDescripcion());
        
        experienceservice.guardarExperiencia(experiencia);
        
        return new ResponseEntity(new Message("Experiencia Laboral Actualizada"), HttpStatus.OK);
        
        
    }
    
}
