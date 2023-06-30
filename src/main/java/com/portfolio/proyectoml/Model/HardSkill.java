
package com.portfolio.proyectoml.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HardSkill {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    
    private int id;
    private String habilidad;
    private int porcentaje;
    private String img;

    public HardSkill() {
    }

    public HardSkill(String habilidad, int porcentaje, String img) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.img = img;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    

    
    
    
    
    
}
