/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DatosBD.UsuarioBD;
import Model.Carpeta;
import Model.JsonUtil;
import Model.User;
import Model.Usuario;
import Service.UsuarioService;
import exceptions.InvalidDataException;
import exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class UsuarioController {

    UsuarioBD usuarioBD =new UsuarioBD();
    
  
    
    public User getUsuerioCompletoBYUser(String usuario) throws IOException{
    
        return usuarioBD.getUsuarioCompletoByUser(usuario);
                
    }
    
    public Carpeta getSubCarpeta(String codigoUsuario, String codigoCarpeta){
        
        if(codigoCarpeta!=null || codigoUsuario!=null){
            
            
            
            return usuarioBD.getSubcarpeta(codigoUsuario, codigoCarpeta);
            
        
        }
        
    
    return null;
    }

    
    public Usuario crearUsuario(Usuario usuario){
    
    return usuarioBD.crearUsuario(usuario);
    }
    
}
