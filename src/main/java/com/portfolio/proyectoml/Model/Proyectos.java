
package com.portfolio.proyectoml.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    
    private int id;
    private String nombre;
    private String img;
    private String descripcion;
    private String link;

    public Proyectos() {
    }

    public Proyectos(String nombre, String img, String descripcion, String link) {
        this.nombre = nombre;
        this.img = img;
        this.descripcion = descripcion;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
    
    
    
}
