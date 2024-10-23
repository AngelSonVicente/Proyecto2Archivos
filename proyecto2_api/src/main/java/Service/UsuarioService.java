/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Controller.UsuarioController;
import Model.JsonUtil;
import Model.Usuario;
import DatosBD.UsuarioBD;
import exceptions.InvalidDataException;
import exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class UsuarioService {

    JsonUtil jsonUtil = new JsonUtil();

    UsuarioController usuarioController = new UsuarioController();

    public void CrearUsuario(String body, HttpServletResponse response) throws InvalidDataException, IOException, SQLException {

        Usuario usuario = (Usuario) jsonUtil.JsonStringAObjeto(body, Usuario.class);

        usuario = usuarioController.crearUsuario(usuario);

        if (usuario != null) {
            jsonUtil.EnviarJson(response, usuario);

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

}
