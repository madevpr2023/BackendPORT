
package com.portfolio.proyectoml.DTO;

public class HardSkillDTO {
    
    private String habilidad;
    private int porcentaje;
    private String img;

    public HardSkillDTO() {
    }

    public HardSkillDTO(String habilidad, int porcentaje, String img) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.img = img;
        
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
