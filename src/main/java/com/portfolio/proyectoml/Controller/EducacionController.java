
package com.portfolio.proyectoml.Controller;

import com.portfolio.proyectoml.DTO.EducacionDTO;
import com.portfolio.proyectoml.Model.Educacion;
import com.portfolio.proyectoml.Secure.Controller.Message;
import com.portfolio.proyectoml.Service.EducacionServ;
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
@RequestMapping("/Educacion")

public class EducacionController {
    
    @Autowired
    
    EducacionServ educationservice;
    
    @GetMapping("/listadoeducacion")
    
    public ResponseEntity<List<Educacion>> listadoEducacion(){
    
        List<Educacion> listado = educationservice.listaEducacion();
        
        return new ResponseEntity(listado, HttpStatus.OK);
        
    }
    
    @GetMapping("/educaciondet/{id}")
    
    public ResponseEntity<Educacion> ObtenertheId(@PathVariable("id") int id){
    
        if(!educationservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        Educacion education = educationservice.ObtenerId(id).get();
        
        return new ResponseEntity(education, HttpStatus.OK);
        
    
        
    }
    
    @DeleteMapping("/eliminareducacion/{id}")
    
    
    public ResponseEntity<?> Eliminacion(@PathVariable("id") int id){
    
        if(!educationservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion no encontrada"), HttpStatus.NOT_FOUND);
            
        }
        
        educationservice.eliminarEducacion(id);
        
        return new ResponseEntity(new Message("Educacion eliminada exitosamente"), HttpStatus.OK);
        
    }
    
    @PostMapping("/creareducacion")
   
    
    public ResponseEntity<?> NuevaEducacion (@RequestBody EducacionDTO dtoeduc){
    
        if(StringUtils.isBlank(dtoeduc.getInstitucion())){
        
            return new ResponseEntity(new Message("Institucion Obligatoria"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(educationservice.ExisteNombre(dtoeduc.getInstitucion())){
        
            return new ResponseEntity(new Message("La Educacion se encuentra registrada"), HttpStatus.BAD_REQUEST);
            
        }
        
        Educacion education = new Educacion(dtoeduc.getInstitucion(), dtoeduc.getAnioInicio(), dtoeduc.getAnioFin(), dtoeduc.getTitulo_obtenido(), dtoeduc.getImg());
        
        educationservice.guardarEducacion(education);
        
        return new ResponseEntity(new Message("Educacion registrada exitosamente"), HttpStatus.OK);
        
    }
    
    @PutMapping("/editareducacion/{id}")
    
    
    public ResponseEntity<?> Actualizacion(@PathVariable("id") int id, @RequestBody EducacionDTO dtoeduc){
    
        
        if(!educationservice.ExisteId(id)){
        
            return new ResponseEntity(new Message("Educacion no encontrada"), HttpStatus.NOT_FOUND);
            
            
        }
        
        if(educationservice.ExisteNombre(dtoeduc.getInstitucion()) && educationservice.Obtener(dtoeduc.getInstitucion()).get().getId() != id){
        
            return new ResponseEntity(new Message("Educacion ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(StringUtils.isBlank(dtoeduc.getInstitucion())){
        
            return new ResponseEntity(new Message("El nombre de la institucion es obligatorio"), HttpStatus.BAD_REQUEST);
            
        }
        
        Educacion educacion = educationservice.ObtenerId(id).get();
        
        educacion.setInstitucion(dtoeduc.getInstitucion());
        
        educacion.setAnioInicio(dtoeduc.getAnioInicio());
        
        educacion.setAnioFin(dtoeduc.getAnioFin());
        
        educacion.setTitulo_obtenido(dtoeduc.getTitulo_obtenido());
        
        educationservice.guardarEducacion(educacion);
        
        return new ResponseEntity(new Message("Educacion Actualizada"), HttpStatus.OK);
        
        
    }
        
    
    
    
    
    
}
