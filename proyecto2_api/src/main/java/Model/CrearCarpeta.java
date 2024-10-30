/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angel
 */
public class CrearCarpeta {
    
    private String codigoUsuario;
    private String codigoCarpetaPadre;
    private String pathPadre;
    private String nombre;

    public CrearCarpeta() {
    }

    public CrearCarpeta(String codigoUsuario, String codigoCarpetaPadre, String pathPadre, String nombre) {
        this.codigoUsuario = codigoUsuario;
        this.codigoCarpetaPadre = codigoCarpetaPadre;
        this.pathPadre = pathPadre;
        this.nombre = nombre;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoCarpetaPadre() {
        return codigoCarpetaPadre;
    }

    public void setCodigoCarpetaPadre(String codigoCarpetaPadre) {
        this.codigoCarpetaPadre = codigoCarpetaPadre;
    }

    public String getPathPadre() {
        return pathPadre;
    }

    public void setPathPadre(String pathPadre) {
        this.pathPadre = pathPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CrearCarpeta{" + "codigoUsuario=" + codigoUsuario + ", codigoCarpetaPadre=" + codigoCarpetaPadre + ", pathPadre=" + pathPadre + ", nombre=" + nombre + '}';
    }
    
    
    
}
