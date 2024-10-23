/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author MSI
 */
public class Cliente {
    
    private int nit;
    private String nombre;
    private String correo;
    private String direccion;
    private float totalGastado;
    private int puntos;
    private String tipo;
    private String fecha;

    public Cliente() {
    }

    public Cliente(int nit, String nombre, String correo, String direccion, float totalGastado, int puntos, String tipo, String fecha) {
        this.nit = nit;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.totalGastado = totalGastado;
        this.puntos = puntos;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(float totalGastado) {
        this.totalGastado = totalGastado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nit=" + nit + ", nombre=" + nombre + ", correo=" + correo + ", direccion=" + direccion + ", totalGastado=" + totalGastado + ", puntos=" + puntos + ", tipo=" + tipo + ", fecha=" + fecha + '}';
    }
    
    
    

    
    
    
    
}
