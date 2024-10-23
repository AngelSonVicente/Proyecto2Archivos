/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.LoginBD;
import DatosBD.UsuarioBD;
import Model.Usuario;
import Model.Util;

/**
 *
 * @author MSI
 */
public class LoginController {
    
    private LoginBD loginBD= new LoginBD();
    private Util util = new Util();
    
        public Usuario IsLogin(String ContraIngresada, int codigo, String tipo) {

        UsuarioBD usuarioBD = new UsuarioBD();
        String ContraEncriptada = util.Encriptar(ContraIngresada);

        String Contra = loginBD.obtnerContra(codigo,tipo);
        Usuario usuario = new Usuario();

        System.out.println("contra ingresada: " + ContraEncriptada);
        System.out.println("usuario ingresado: " + codigo);
        System.out.println("contra : " + Contra);
        System.out.println("contra : " + Contra);
        

        if (ContraEncriptada.equals(Contra)) {
            System.out.println("si ingresó");

            usuario = usuarioBD.getUsuarioCodigo(codigo);
          
            return usuario;

        }else{
            System.out.println("NO INGRESO :c ");
        }

        return null;
    }
    
    
}
