/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author angel
 */
public class Carpeta {
    
    private String _id;
    private String nombre;
    private String path;
    private List<Archivo> archivos;
    private List<Carpeta> subcarpetas;

    public Carpeta() {
    }

    public Carpeta(String _id, String nombre, String path, List<Archivo> archivos, List<Carpeta> subcarpetas) {
        this._id = _id;
        this.nombre = nombre;
        this.path = path;
        this.archivos = archivos;
        this.subcarpetas = subcarpetas;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

    public List<Carpeta> getSubcarpetas() {
        return subcarpetas;
    }

    public void setSubcarpetas(List<Carpeta> subcarpetas) {
        this.subcarpetas = subcarpetas;
    }

    @Override
    public String toString() {
        return "Carpeta{" + "_id=" + _id + ", nombre=" + nombre + ", path=" + path + ", archivos=" + archivos + ", subcarpetas=" + subcarpetas + '}';
    }

    
    
}
