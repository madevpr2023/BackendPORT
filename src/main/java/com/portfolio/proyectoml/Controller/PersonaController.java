
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.PersonaDTO;
import com.portfolio.proyectoml.Model.Persona;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.PersonaServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Perfil")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    
    PersonaServ personservice;
    
    @GetMapping("/perfil")
    
    public ResponseEntity<List<Persona>> listadoPerfil(){
    
        List<Persona> listado = personservice.ListaPersona();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/perfildet/{id}")
    
    public ResponseEntity<Persona> ObtenertheId(@PathVariable("id") int id){
    
        if(!personservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Id de perfil no encontrado"), HttpStatus.NOT_FOUND);
            
        }
        
        Persona person = personservice.ObtenerId(id).get();
        
        return new ResponseEntity(person, HttpStatus.OK);
        
    
        
    }
    
    @PutMapping("/editarperfil/{id}")
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody PersonaDTO dtoper){
    
        
        if(!personservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Perfil no encontrado"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(personservice.ExisteNombre(dtoper.getNombre()) && personservice.Obtener(dtoper.getNombre()).get().getId() != id){
        
            return new ResponseEntity(new Message("Perfil ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtoper.getNombre())){
        
            return new ResponseEntity(new Message("El nombre del perfil es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        Persona persona = personservice.ObtenerId(id).get();
        
        persona.setNombre(dtoper.getNombre());
        
        persona.setApellido(dtoper.getApellido());
        
        persona.setPuesto(dtoper.getPuesto());
        
        persona.setAdress(dtoper.getAdress());
        
        persona.setDescripcion(dtoper.getDescripcion());
        
        persona.setImg(dtoper.getImg());
        
        personservice.CrearPersona(persona);
        
        return new ResponseEntity(new Message("Perfil Actualizado"), HttpStatus.OK);
        
        
    }
    
    
}
