
package com.portfolio.proyectoml.Secure.JWT;

import com.portfolio.proyectoml.Secure.Entity.UserPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    
    private int expiracion;
    
    public String generateToken(Authentication autenticacion){
    
        UserPrincipal userPrincipal = (UserPrincipal) autenticacion.getPrincipal();
        
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiracion * 1000))
                .signWith(getSecret(secret)).compact();
        
    }
    
    private Key getSecret(String secret){
    
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        
        return Keys.hmacShaKeyFor(secretBytes);
        
    }
    

    public String getNombreUserFromToken(String token){
    
        return Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token).getBody().getSubject();
        
        
        
    }
    
    public boolean validateToken(String token){
    
        try{
        
            Jwts.parserBuilder().setSigningKey(getSecret(secret)).build().parseClaimsJws(token);
            
            return true;
            
        }
        
        catch(MalformedJwtException e){
        
            logger.error("Token mal formado");
            
        }
        
        catch(UnsupportedJwtException e){
        
            logger.error("Token no soportado");
            
        }
        
        catch(ExpiredJwtException e){
        
            logger.error("Token Expirado");
            
        }
        
        catch(IllegalArgumentException e){
        
            logger.error("Token vacio");
            
        }
        
        catch(SignatureException e){
        
            logger.error("Firma no valida");
            
        }
        
        return false;
        
    }
    
}
