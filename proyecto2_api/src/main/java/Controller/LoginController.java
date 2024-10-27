/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DatosBD.LoginBD;
import DatosBD.UsuarioBD;
import Model.Usuario;
import Model.Util;
import java.io.IOException;

/**
 *
 * @author MSI
 */
public class LoginController {

    private LoginBD loginBD = new LoginBD();
    private Util util = new Util();

    public Usuario IsLogin(String ContraIngresada, String usuarioIngresado, String tipo) throws IOException {

        UsuarioBD usuarioBD = new UsuarioBD();
        String ContraEncriptada = util.Encriptar(ContraIngresada);

        String Contra = loginBD.obtnerContra(usuarioIngresado);

        Usuario usuario = new Usuario();

        System.out.println("contra ingresada: " + ContraEncriptada);
        System.out.println("usuario ingresado: " + usuarioIngresado);
        System.out.println("contra real : " + Contra);

        if (ContraEncriptada.equals(Contra)) {
            System.out.println("\n SI INGRESOOO");

            usuario = usuarioBD.getUsuarioByUser(usuarioIngresado);

            return usuario;

        } else {
            System.out.println("NO INGRESO :c ");
        }

        return null;
    }

}
