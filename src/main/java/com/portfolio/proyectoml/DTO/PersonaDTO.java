
package com.portfolio.proyectoml.DTO;


public class PersonaDTO {
    
    private String nombre;
    private String apellido;
    private String puesto;
    private String adress;
    private String descripcion;
    private String img;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, String puesto, String adress, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.adress = adress;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    
}
