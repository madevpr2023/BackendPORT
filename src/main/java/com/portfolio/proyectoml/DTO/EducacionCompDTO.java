
package com.portfolio.proyectoml.DTO;




public class EducacionCompDTO {
    
    private String institucion;
    private String curso;
    private String anioInicio;
    private String anioFin;
    private String img;

    public EducacionCompDTO() {
    }

    public EducacionCompDTO(String institucion, String curso, String anioInicio, String anioFin, String img) {
        this.institucion = institucion;
        this.curso = curso;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.img = img;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    
}
