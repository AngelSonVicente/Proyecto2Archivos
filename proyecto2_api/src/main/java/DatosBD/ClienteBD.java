/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;


import Model.Cliente;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MSI
 */
public class ClienteBD {

    Connection conexion = null;

    public ClienteBD() {
        ConexionPG conexionPg = new ConexionPG();
        conexion = conexionPg.getConexion();

    }
    private static final String SELECT_BY_NIT = "SELECT * FROM ventas.cliente_view WHERE nit=?;";
    private static final String CREAR_USUARIO = "INSERT INTO ventas.clientes (nit,nombre,correo,direccion) values (?,?,?,?);";

    public Cliente getClienteNit(int nit) {
        // validateCarnet not null
        try {
            PreparedStatement select = conexion.prepareStatement(SELECT_BY_NIT);
            select.setInt(1, nit);
            ResultSet resultset = select.executeQuery();
            System.out.println("----------------------------------------------------");
            System.out.println(select.toString());

            if (resultset.next()) {
                return new Cliente(resultset.getInt("nit"),
                        resultset.getString("nombre"), resultset.getString("correo"),
                        resultset.getString("direccion"), resultset.getFloat("total_gastado"),
                        resultset.getInt("puntos"), resultset.getString("tipo"), resultset.getString("fecha_creacion")
                );
            }

            return null;
        } catch (SQLException ex) {
            // TODO pendiente manejo
            ex.printStackTrace();
        }

        return null;
    }


    

}
