package Service;

import Controller.LoginController;
import Model.JsonUtil;
import Model.TipoUsuario;
import DatosBD.ConexionBD;
import DatosBD.ConexionMongo;
import Model.Usuario;
import Model.Util;
import DatosBD.UsuarioBD;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import exceptions.InvalidDataException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.bson.Document;

public class LoginService {

    static Connection conexion = ConexionBD.getInstancia().getConexion();

    private JsonUtil jsonUtil = new JsonUtil();
    private LoginController loginCOntroller = new LoginController();

    public void procesarSolicitud(String body, HttpServletResponse response) throws IOException, InvalidDataException, InvalidDataException, InvalidDataException {

      
        Usuario UsuarioFE = (Usuario) jsonUtil.JsonStringAObjeto(body, Usuario.class);

        System.out.println("usuario_ " + UsuarioFE);
        System.out.println("Tipo de usuario: " + UsuarioFE.getTipo());
        System.out.println("usuario de usuario: " + UsuarioFE.getUsuario());
        System.out.println("contra de usuario: " + UsuarioFE.getPassword());
        System.out.println("Tipo: " + UsuarioFE.getTipo());

        Usuario usuario = new Usuario();


        
        
        
        validar(UsuarioFE);

        usuario = loginCOntroller.IsLogin(UsuarioFE.getPassword(), UsuarioFE.getUsuario(), UsuarioFE.getTipo());

        
        
        if (usuario != null) {
            jsonUtil.EnviarJson(response, usuario);

            response.setStatus(HttpServletResponse.SC_OK);

        } else {

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

    private void validar(Usuario usuario) throws InvalidDataException {

        if (usuario.getUsuario() == null || usuario.getPassword() == null || usuario.getTipo() == null) {
            throw new InvalidDataException("los datos no estan completos, por favor reviselos!");

        }

    }

//    Util util = new Util();
//
//    private static final String SelectPassword = "SELECT password FROM usuarios WHERE usuario = ?";
//
//    public Usuario IsLogin(String ContraIngresada, String UsuarioIngresado) {
//
//        UsuarioBD usuarioBD = new UsuarioBD();
//        String ContraEncriptada = util.Encriptar(ContraIngresada);
//
//        String Contra = obtnerContra(UsuarioIngresado);
//        Usuario usuario = new Usuario();
//
//        System.out.println("contra ingresada: " + ContraEncriptada);
//        System.out.println("usuario ingresado: " + UsuarioIngresado);
//        System.out.println("contra : " + Contra);
//        
//        
//        
//        
//
//        if (ContraEncriptada.equals(Contra)) {
//            System.out.println("si ingresó");
//
//            usuario = usuarioBD.getUsuarioByUser(UsuarioIngresado);
//          
//            return usuario;
//
//        }
//
//        return null;
//    }
//
//    private String obtnerContra(String Usuario) {
//        try {
//            PreparedStatement select = conexion.prepareStatement(SelectPassword);
//            select.setString(1, Usuario);
//            ResultSet resultset = select.executeQuery();
//
//            if (resultset.next()) {
//                return resultset.getString("password");
//            }
//
//            return null;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
}
