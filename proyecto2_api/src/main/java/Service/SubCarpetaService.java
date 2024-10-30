/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DatosBD.UsuarioBD;
import Model.Carpeta;
import Model.CrearCarpeta;
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

    public void CrearSubCarpeta(String body, HttpServletResponse response) throws IOException {

        CrearCarpeta carpetaCreacion = (CrearCarpeta) jsonutil.JsonStringAObjeto(body, CrearCarpeta.class);

        
        //si el codigo de la carpeta padre es nulo, entonces se va a crear en la carpeta raiz, sino se va a crear dentro de una sub carpeta
        if (carpetaCreacion.getCodigoCarpetaPadre() == null) {

            if (usuarioBD.agregarSubcarpeta(carpetaCreacion.getCodigoUsuario(), carpetaCreacion.getNombre(),carpetaCreacion.getPathPadre())) {

                jsonutil.EnviarJson(response, carpetaCreacion);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            }

            
        } else {

            if (usuarioBD.agregarSubcarpeta(carpetaCreacion.getCodigoUsuario(), carpetaCreacion.getCodigoCarpetaPadre(), carpetaCreacion.getNombre(),carpetaCreacion.getPathPadre())) {

                jsonutil.EnviarJson(response, carpetaCreacion);

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            }

        }

    }

}
