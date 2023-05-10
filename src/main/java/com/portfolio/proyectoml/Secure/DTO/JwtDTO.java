
package com.portfolio.proyectoml.Secure.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {
    
    private String token;
    private String bearer = "Bearer";
    private String NameUser;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String NameUser, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.NameUser = NameUser;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
    
}
