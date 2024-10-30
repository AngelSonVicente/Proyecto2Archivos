/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DatosBD.UsuarioBD;
import Model.Carpeta;
import Model.JsonUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class SubCarpetaService {

    UsuarioBD usuarioBD = new UsuarioBD();
    JsonUtil jsonutil = new JsonUtil();

    public void getSubCarpeta(String codigoUsuario, String codigoCarpeta, HttpServletResponse reponse) throws IOException {

        Carpeta carpeta = usuarioBD.getSubcarpeta(codigoUsuario, codigoCarpeta);

        if (carpeta != null) {

            jsonutil.EnviarJson(reponse, carpeta);
        } else {
            reponse.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

}
