
package com.portfolio.proyectoml.DTO;


public class ProyectosDTO {
    
    private String nombre;
    private String img;
    private String descripcion;
    private String link;

    public ProyectosDTO() {
    }

    public ProyectosDTO(String nombre, String img, String descripcion, String link) {
        this.nombre = nombre;
        this.img = img;
        this.descripcion = descripcion;
        this.link = link;
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
