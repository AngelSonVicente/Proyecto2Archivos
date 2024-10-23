/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DatosBD.UsuarioBD;
import Model.JsonUtil;
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
    
    public Usuario crearUsuario (Usuario usuario) throws SQLException{
        return usuarioBD.crearUsuario(usuario);
    
    
    
    }

    
}
