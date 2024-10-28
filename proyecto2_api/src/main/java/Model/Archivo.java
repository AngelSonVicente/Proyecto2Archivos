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
    private String nombre;
    private String tipo;
    private byte[]contenido;
    private int tamaño;

    public Archivo() {
    }

    public Archivo(String _id, String nombre, String tipo, byte[] contenido, int tamaño) {
        this._id = _id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
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
        return "Archivo{" + "_id=" + _id + ", nombre=" + nombre + ", tipo=" + tipo + ", contenido=" + contenido + ", tama\u00f1o=" + tamaño + '}';
    }

    
    
    
}
