/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DatosBD.ArchivoBD;
import DatosBD.UsuarioBD;
import Model.Archivo;
import Model.ArchivoActualizar;
import Model.CrearArchivo;
import Model.JsonUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author angel
 */
public class ArchivosService {

    JsonUtil jsonUtil = new JsonUtil();
    ArchivoBD archivoBD = new ArchivoBD();

    public void crearArchivo(String body, HttpServletResponse response) throws IOException {

        CrearArchivo crearArchivo = (CrearArchivo) jsonUtil.JsonStringAObjeto(body, CrearArchivo.class);

        Archivo archivoCreado = archivoBD.agregarArchivoEnCarpetaRaiz(crearArchivo.getCodigoUsuario(), crearArchivo.getNombre(), crearArchivo.getTipo(), crearArchivo.getPath());

        if (crearArchivo.getCodigoCarpeta() == null) {
            if (archivoCreado != null) {

                jsonUtil.EnviarJson(response, archivoCreado);

            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            }

        } else {

        }

    }

    public void ActualizarArchivo(String body, HttpServletResponse response) throws IOException {

        ArchivoActualizar archivo = (ArchivoActualizar) jsonUtil.JsonStringAObjeto(body, ArchivoActualizar.class);

        
        System.out.println("ARCHIVO ENCONTRADO "+archivo);
        if (archivoBD.actualizarContenidoArchivo(archivo.getCodigoUsuario(), archivo.getId(), archivo.getContenido())) {

            jsonUtil.EnviarJson(response, archivo);

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }

   
    
    
    
    public void getArchivho(String codigoUsuario, String codigoCarpeta, String codigoArchivo, HttpServletResponse response) throws IOException{
        
       Archivo archivo =  archivoBD.obtenerArchivoEnCarpetaRaiz(codigoUsuario, codigoArchivo);
        
       if(archivo!=null){
           jsonUtil.EnviarJson(response, archivo);
           
           
           
       
       }else{
           response.setStatus(HttpServletResponse.SC_NOT_FOUND);

       }
    
    
    
    }
    
    
    
}
