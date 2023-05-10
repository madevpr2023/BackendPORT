
package com.portfolio.proyectoml.Secure.Entity;

import com.portfolio.proyectoml.Secure.Enums.RolName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Enumerated(EnumType.STRING)
    private RolName rolnombre;

    public Role() {
    }

    public Role(RolName rolnombre) {
        this.rolnombre = rolnombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolName getRolnombre() {
        return rolnombre;
    }

    public void setRolnombre(RolName rolnombre) {
        this.rolnombre = rolnombre;
    }
    
    
    
    
}
