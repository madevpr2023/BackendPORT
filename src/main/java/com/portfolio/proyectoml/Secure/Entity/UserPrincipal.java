
package com.portfolio.proyectoml.Secure.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserPrincipal implements UserDetails{
    
    private String nombre;
    private String nameUser;
    private String email;
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String nombre, String nameUser, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static UserPrincipal build(User usuario){
        
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol-> new SimpleGrantedAuthority(rol.getRolnombre().name())).collect(Collectors.toList());
        
        return new UserPrincipal(usuario.getNombre(), usuario.getNameUser(), usuario.getEmail(), usuario.getPassword(),authorities);
    
     
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUser;
    }
    
    public String GetNombre(){
    
        return nombre;
    }
    
    public String GetEmail(){
    
        return email;
        
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return true;
    }
    
    
    
    
}
