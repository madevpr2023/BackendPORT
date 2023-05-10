
package com.portfolio.proyectoml.DTO;


public class ExperienciaDTO {
    
    
    private String empresa;
    private String puesto;
    private int anioInicio;
    private int anioFin;
    private String descripcion;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String empresa, String puesto, int anioInicio, int anioFin, String descripcion) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
