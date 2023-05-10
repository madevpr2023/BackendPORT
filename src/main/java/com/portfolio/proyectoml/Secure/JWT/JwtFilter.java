package com.portfolio.proyectoml.Secure.JWT;

import com.portfolio.proyectoml.Secure.Service.UserDetailsIm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter{
    
    private final static Logger log = LoggerFactory.getLogger(JwtFilter.class);
    
    @Autowired
    
    JwtProvider jwtprov;
    
    @Autowired 
    
    UserDetailsIm userdetim;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        String token = getToken(request);
        
        try{
        
        if(token != null && jwtprov.validateToken(token)){
        
            String nameUser = jwtprov.getNombreUserFromToken(token);
            
            UserDetails userdet = userdetim.loadUserByUsername(nameUser);
            
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userdet, null, userdet.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(auth);
            
        }
        
        }
        
        catch(Exception e){
        
            log.error("Fallo el metodo doFilterInternal");
            
        }
        
        filterChain.doFilter(request, response);
        
    }
    
    public String getToken(HttpServletRequest request){
    
        String Header = request.getHeader("Authorization");
        
        if(Header !=null && Header.startsWith("Bearer")){
        
            return Header.replace("Bearer", "");
            
        }
           
          return null;
            
        
        
    }
    
    
    
}
