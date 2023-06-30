
package com.portfolio.proyectoml.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EducacionComp {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    
    private int id;
    private String institucion;
    private String curso;
    private String anioInicio;
    private String anioFin;
    

    public EducacionComp() {
    }

    public EducacionComp(String institucion, String curso, String anioInicio, String anioFin) {
        this.institucion = institucion;
        this.curso = curso;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(String anioFin) {
        this.anioFin = anioFin;
    }

    

    

    
    
    
    
    
    
}
