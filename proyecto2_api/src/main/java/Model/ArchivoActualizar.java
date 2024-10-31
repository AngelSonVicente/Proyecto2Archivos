/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angel
 */
public class ArchivoActualizar extends Archivo{
    private String codigoUsuario;

    public ArchivoActualizar(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public ArchivoActualizar(String codigoUsuario, String _id, String carpetaPadre, String nombre, String path, String tipo, String contenido, int tamaño) {
        super(_id, carpetaPadre, nombre, path, tipo, contenido, tamaño);
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    
    
    
    
}
