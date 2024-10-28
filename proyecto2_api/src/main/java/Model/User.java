/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author angel
 */
public class User {

    public User() {
    }
    
    
    private String id ;
    private String usuario;
    private String nombre;
    private String correo;
    private String password;
    private String tipo;
    private Carpeta carpetaRaiz;

    public User(String id, String usuario, String nombre, String correo, String password, String tipo, Carpeta carpetaRaiz) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
        this.carpetaRaiz = carpetaRaiz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carpeta getCarpetaRaiz() {
        return carpetaRaiz;
    }

    public void setCarpetaRaiz(Carpeta carpetaRaiz) {
        this.carpetaRaiz = carpetaRaiz;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", tipo=" + tipo + ", carpetaRaiz=" + carpetaRaiz + '}';
    }
    
    
    
    
    
    
}
