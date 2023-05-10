
package com.portfolio.proyectoml.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    
    private int id;
    private String img;
    private String institucion;
    private String anioInicio;
    private String anioFin;
    private String titulo_obtenido;

    public Educacion() {
    }

    public Educacion(String institucion, String anioInicio, String anioFin, String titulo_obtenido, String img) {
        this.institucion = institucion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.titulo_obtenido = titulo_obtenido;
        this.img = img;
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

    public String getTitulo_obtenido() {
        return titulo_obtenido;
    }

    public void setTitulo_obtenido(String titulo_obtenido) {
        this.titulo_obtenido = titulo_obtenido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    
    
    
}
