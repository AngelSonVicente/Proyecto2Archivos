/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angel
 */
public class CrearArchivo {
    
    private String codigoUsuario;
    private String codigoCarpeta;
    private String nombre;
    private String path;
    private String contenido;
    private String tipo;

    public CrearArchivo() {
    }

    public CrearArchivo(String codigoUsuario, String codigoCarpeta, String nombre, String path, String contenido, String tipo) {
        this.codigoUsuario = codigoUsuario;
        this.codigoCarpeta = codigoCarpeta;
        this.nombre = nombre;
        this.path = path;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoCarpeta() {
        return codigoCarpeta;
    }

    public void setCodigoCarpeta(String codigoCarpeta) {
        this.codigoCarpeta = codigoCarpeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CrearArchivo{" + "codigoUsuario=" + codigoUsuario + ", codigoCarpeta=" + codigoCarpeta + ", nombre=" + nombre + ", path=" + path + ", contenido=" + contenido + ", tipo=" + tipo + '}';
    }
    
    
    
}
