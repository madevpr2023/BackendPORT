
package com.portfolio.proyectoml.DTO;


public class ProyectosDTO {
    
    private String nombre;
    private String descripcion;
    private String link;
   

    public ProyectosDTO() {
    }

    public ProyectosDTO(String nombre,String descripcion, String link) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
