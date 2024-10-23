/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class LoginBD {

    Connection conexion =null;

    public LoginBD() {
        
        ConexionPG conexionPG = new ConexionPG();
       conexion = conexionPG.getConexion();
        
    }
    
    

    
        public String obtnerContra(int codigo, String tipo) {
            
            //solo para los usuarios usuarios :)
         String SelectPassword = "SELECT contrasena FROM empleados."+tipo+" WHERE codigo = ?";
         
            
            
            
        try {
            PreparedStatement select = conexion.prepareStatement(SelectPassword);
           
        
            select.setInt(1, codigo);
            
            System.out.println(select.toString());
            
            ResultSet resultset = select.executeQuery();

            if (resultset.next()) {
                return resultset.getString("contrasena");
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
}
