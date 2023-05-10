
package com.portfolio.proyectoml.DTO;


public class SoftSkillDTO {
    
    private String habilidad;
    private int porcentaje;

    public SoftSkillDTO() {
    }

    public SoftSkillDTO(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
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

    
    
    
    
}
