
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.EducacionCompDTO;
import com.portfolio.proyectoml.Model.EducacionComp;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.EducacionCompServ;
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
@RequestMapping("/Educacion_Complementaria")
public class EducacionCompController {
    
     @Autowired
    
    EducacionCompServ educationcompservice;
    
    @GetMapping("/listadoeducacioncomplementaria")
    
    public ResponseEntity<List<EducacionComp>> ListExp(){
    
        List<EducacionComp> listado = educationcompservice.listaEducacionComp();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/educacioncomplementariadet/{id}")
    
    public ResponseEntity<EducacionComp> ObtenertheId(@PathVariable("id") int id){
    
        if(!educationcompservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion Complementaria no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        EducacionComp educationcomp = educationcompservice.ObtenerId(id).get();
        
        return new ResponseEntity(educationcomp, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminareducacioncomplementaria/{id}")
    
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!educationcompservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion Complementaria no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        educationcompservice.eliminarEducacionComp(id);
        
        return new ResponseEntity(new Message("Educacion Complementaria Eliminada exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/creareducacioncomplementaria")
   
    
    public ResponseEntity<?> NuevaExperiencia(@RequestBody EducacionCompDTO dtoeduccomp){
    
        if(StringUtils.isBlank(dtoeduccomp.getCurso())){
            
            return new ResponseEntity(new Message("El curso es obligatorio"), HttpStatus.BAD_REQUEST);
        
              
        }
        
        if(educationcompservice.ExisteNombre(dtoeduccomp.getCurso())){
        
            return new ResponseEntity(new Message("La experiencia se encuentra registrada"), HttpStatus.BAD_REQUEST);
            
        }
        
        EducacionComp educationcomp = new EducacionComp(dtoeduccomp.getInstitucion(), dtoeduccomp.getCurso(), dtoeduccomp.getAnioInicio(), dtoeduccomp.getAnioFin(), dtoeduccomp.getImg());
        
        educationcompservice.guardarEducacionComp(educationcomp);
        
        return new ResponseEntity(new Message("Educacion Complementaria registrada"), HttpStatus.OK);
    }
    
    @PutMapping("/editareducacioncomplementaria/{id}")
    
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody EducacionCompDTO dtoeduccomp){
    
        
        if(!educationcompservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion Complementaria no encontrada"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(educationcompservice.ExisteNombre(dtoeduccomp.getCurso()) && educationcompservice.Obtener(dtoeduccomp.getCurso()).get().getId() != id){
        
            return new ResponseEntity(new Message("Educacion Complementaria ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtoeduccomp.getCurso())){
        
            return new ResponseEntity(new Message("El nombre del curso es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        EducacionComp educacioncomp = educationcompservice.ObtenerId(id).get();
        
        educacioncomp.setInstitucion(dtoeduccomp.getInstitucion());
        
        educacioncomp.setCurso(dtoeduccomp.getCurso());
        
        educacioncomp.setAnioInicio(dtoeduccomp.getAnioInicio());
        
        educacioncomp.setAnioFin(dtoeduccomp.getAnioFin());
        
        educationcompservice.guardarEducacionComp(educacioncomp);
        
        return new ResponseEntity(new Message("Perfil Actualizado"), HttpStatus.OK);
        
        
    }
    
}
