/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angel
 */
public class Archivo {
    
    private String _id;
    private String carpetaPadre;
    private String nombre;
    private String path;
    private String tipo;
    private String contenido;
    private int tamaño;

    public Archivo() {
    }

    public Archivo(String _id, String carpetaPadre, String nombre, String path, String tipo, String contenido, int tamaño) {
        this._id = _id;
        this.carpetaPadre = carpetaPadre;
        this.nombre = nombre;
        this.path = path;
        this.tipo = tipo;
        this.contenido = contenido;
        this.tamaño = tamaño;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCarpetaPadre() {
        return carpetaPadre;
    }

    public void setCarpetaPadre(String carpetaPadre) {
        this.carpetaPadre = carpetaPadre;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Archivo{" + "_id=" + _id + ", carpetaPadre=" + carpetaPadre + ", nombre=" + nombre + ", path=" + path + ", tipo=" + tipo + ", contenido=" + contenido + ", tama\u00f1o=" + tamaño + '}';
    }

    
}
