
package com.portfolio.proyectoml.DTO;

public class HardSkillDTO {
    
    private String habilidad;
    private int porcentaje;
    

    public HardSkillDTO() {
    }

    public HardSkillDTO(String habilidad, int porcentaje) {
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
