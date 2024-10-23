package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class Usuario {

  private int codigo;
  private String nombre;
  private String usuario;
  private String correo;
  private String password;
  private String tipo;
  private  int codigoSucursal;
  private int codigoCaja;
  private int codigoBodega;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String usuario, String correo, String password, String tipo, int codigoSucursal, int codigoCaja, int codigoBodega) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.tipo = tipo;
        this.codigoSucursal = codigoSucursal;
        this.codigoCaja = codigoCaja;
        this.codigoBodega = codigoBodega;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public int getCodigoCaja() {
        return codigoCaja;
    }

    public void setCodigoCaja(int codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public int getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(int codigoBodega) {
        this.codigoBodega = codigoBodega;
    }
  
  
    

    

}
