
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.SoftSkillDTO;
import com.portfolio.proyectoml.Model.SoftSkill;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.SoftSkillServ;
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
@RequestMapping("/Soft_Skill")
public class SoftSkillController {
    
     @Autowired
    
    SoftSkillServ sskservice;
    
    @GetMapping("/listadosoftskill")
    
    public ResponseEntity<List<SoftSkill>> ListSS(){
    
        List<SoftSkill> listado = sskservice.listaSoftSkill();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/softskilldet/{id}")
    
    public ResponseEntity<SoftSkill> ObtenertheId(@PathVariable("id") int id){
    
        if(!sskservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Soft Skill no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        SoftSkill softskill = sskservice.ObtenerId(id).get();
        
        return new ResponseEntity(softskill, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarsoftskill/{id}")
   
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!sskservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Soft Skill no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        sskservice.eliminarSoftSkill(id);
        
        return new ResponseEntity(new Message("Soft Skill Eliminada exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/crearsoftskill")
    
    
    public ResponseEntity<?> NuevoSoftSkill(@RequestBody SoftSkillDTO dtoss){
    
        if(StringUtils.isBlank(dtoss.getHabilidad())){
            
            return new ResponseEntity(new Message("La habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
        
              
        }
        
        if(sskservice.ExisteNombre(dtoss.getHabilidad())){
        
            return new ResponseEntity(new Message("El soft skill se encuentra registrada"), HttpStatus.BAD_REQUEST);
            
        }
        
        SoftSkill softskill = new SoftSkill(dtoss.getHabilidad(), dtoss.getPorcentaje());
        
        sskservice.guardarSoftSkill(softskill);
        
        return new ResponseEntity(new Message("Soft Skill registrado"), HttpStatus.OK);
    }
    
    @PutMapping("/editarsoftskill/{id}")
    
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody SoftSkillDTO dtoss){
    
        
        if(!sskservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Soft Skill no encontrado"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(sskservice.ExisteNombre(dtoss.getHabilidad()) && sskservice.Obtener(dtoss.getHabilidad()).get().getId() != id){
        
            return new ResponseEntity(new Message("Soft Skill ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtoss.getHabilidad())){
        
            return new ResponseEntity(new Message("El habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        SoftSkill softskill = sskservice.ObtenerId(id).get();
        
        softskill.setHabilidad(dtoss.getHabilidad());
        
        softskill.setPorcentaje(dtoss.getPorcentaje());
        
        sskservice.guardarSoftSkill(softskill);
        
        return new ResponseEntity(new Message("Soft Skill Actualizado"), HttpStatus.OK);
        
        
    }
    
}
