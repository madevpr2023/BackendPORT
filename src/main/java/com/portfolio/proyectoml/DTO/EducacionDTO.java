
package com.portfolio.proyectoml.DTO;




public class EducacionDTO {
    
    private String institucion;
    private String anioInicio;
    private String anioFin;
    private String titulo_obtenido;
    

    public EducacionDTO() {
    }

    public EducacionDTO(String institucion, String anioInicio, String anioFin, String titulo_obtenido) {
        this.institucion = institucion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.titulo_obtenido = titulo_obtenido;
  
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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

    public String getTitulo_obtenido() {
        return titulo_obtenido;
    }

    public void setTitulo_obtenido(String titulo_obtenido) {
        this.titulo_obtenido = titulo_obtenido;
    }


    

    
    
    
    
    
}
