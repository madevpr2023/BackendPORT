
package com.portfolio.proyectoml.Secure.Controller;

import com.portfolio.proyectoml.Secure.DTO.JwtDTO;
import com.portfolio.proyectoml.Secure.DTO.LoginUser;
import com.portfolio.proyectoml.Secure.DTO.NuevoUsuario;
import com.portfolio.proyectoml.Secure.Entity.Role;
import com.portfolio.proyectoml.Secure.Entity.User;
import com.portfolio.proyectoml.Secure.Enums.RolName;
import com.portfolio.proyectoml.Secure.JWT.JwtProvider;
import com.portfolio.proyectoml.Secure.Service.RoleServ;
import com.portfolio.proyectoml.Secure.Service.UserServ;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolioap-14eec.web.app", "http://localhost:4200"})
@RequestMapping("/accountlogin")
public class LoginController {
    
    @Autowired
    
    PasswordEncoder passencondr;
    
    @Autowired
    
    AuthenticationManager authmanager;
    
    @Autowired
    
    UserServ usuarioservice;
    
    @Autowired
    
    RoleServ rolservice;
    
    @Autowired
    
    JwtProvider jwtprovider;
    
    
    @PostMapping("/nuevouser")
    public ResponseEntity<?> NuevoUser(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bresult){
    
        if(bresult.hasErrors()){
        
            return new ResponseEntity(new Message("Campos invalidos"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(usuarioservice.existsByNameUser(nuevoUsuario.getNameUser())){
        
            return new ResponseEntity(new Message("Nombre de Usuario existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        if(usuarioservice.existsByEmail(nuevoUsuario.getEmail())){
        
            return new ResponseEntity(new Message("Email ya existente"), HttpStatus.BAD_REQUEST);
            
        }
        
        User usuario = new User(nuevoUsuario.getName(), nuevoUsuario.getNameUser(), nuevoUsuario.getEmail(), passencondr.encode(nuevoUsuario.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        
        roles.add(rolservice.getByRoleName(RolName.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin")){
        
            roles.add(rolservice.getByRoleName(RolName.ROLE_ADMIN).get());
            
        }
        
        usuario.setRoles(roles);
        
        usuarioservice.guardarUsuario(usuario);
        
        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
        
    }
    
    @PostMapping("/loginusuario")
    
    public ResponseEntity<JwtDTO> LoginUsuario(@RequestBody LoginUser loguser, BindingResult bresult1){
    
        if(bresult1.hasErrors()){
        
            return new ResponseEntity(new Message("Campos no validos"), HttpStatus.BAD_REQUEST);
            
        }
        
        Authentication authentication = authmanager.authenticate(new UsernamePasswordAuthenticationToken(loguser.getNameUser(), loguser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtprovider.generateToken(authentication);
        
        UserDetails userdet = (UserDetails) authentication.getPrincipal();
        
        JwtDTO jwtDTO = new JwtDTO(jwt, userdet.getUsername(), userdet.getAuthorities());
        
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
        
    }
  
    
    
}
