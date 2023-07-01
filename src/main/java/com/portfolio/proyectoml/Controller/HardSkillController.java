
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.HardSkillDTO;
import com.portfolio.proyectoml.Model.HardSkill;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.HardSkillServ;
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
@RequestMapping("/Hard_Skill")
public class HardSkillController {
    
    @Autowired
    
    HardSkillServ hsservice;
    
    @GetMapping("/listadohardskill")
    
    public ResponseEntity<List<HardSkill>> ListHardSkill(){
    
        List<HardSkill> listado = hsservice.listaHardSkill();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/hardskilldet/{id}")
    
    public ResponseEntity<HardSkill> ObtenertheId(@PathVariable("id") int id){
    
        if(!hsservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Hard Skill no encontrado"), HttpStatus.NOT_FOUND);
            
        }
        
        HardSkill hardskill = hsservice.ObtenerId(id).get();
        
        return new ResponseEntity(hardskill, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarhardskill/{id}")
   
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!hsservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Hard Skill no encontrado"), HttpStatus.NOT_FOUND);
            
        }
        
        hsservice.eliminarHardSkill(id);
        
        return new ResponseEntity(new Message("Hard Skill Eliminado exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/crearhardskill")
   
    
    public ResponseEntity<?> NuevaExperiencia(@RequestBody HardSkillDTO dtohss){
    
        if(StringUtils.isBlank(dtohss.getHabilidad())){
            
            return new ResponseEntity(new Message("La habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        
              
        }
        
        if(hsservice.ExisteNombre(dtohss.getHabilidad())){
        
            return new ResponseEntity(new Message("La habilidad se encuentra registrada"), HttpStatus.BAD_REQUEST);
            
        }
        
        HardSkill hardskill = new HardSkill(dtohss.getHabilidad(), dtohss.getPorcentaje());
        
        hsservice.guardarHardSkill(hardskill);
        
        return new ResponseEntity(new Message("Hard Skill registrado"), HttpStatus.OK);
    }
    
    @PutMapping("/editarhardskill/{id}")
    
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody HardSkillDTO dtohs){
    
        
        if(!hsservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Hard Skill no encontrado"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(hsservice.ExisteNombre(dtohs.getHabilidad()) && hsservice.Obtener(dtohs.getHabilidad()).get().getId() != id){
        
            return new ResponseEntity(new Message("Hard Skill ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtohs.getHabilidad())){
        
            return new ResponseEntity(new Message("La habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        HardSkill hardskill = hsservice.ObtenerId(id).get();
        
        hardskill.setHabilidad(dtohs.getHabilidad());
        
        hardskill.setPorcentaje(dtohs.getPorcentaje());
        
        hsservice.guardarHardSkill(hardskill);
        
        return new ResponseEntity(new Message("Hard Skill Actualizado"), HttpStatus.OK);
        
        
    }
    
}
