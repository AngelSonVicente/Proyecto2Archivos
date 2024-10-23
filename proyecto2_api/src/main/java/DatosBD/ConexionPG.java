/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MSI
 */
public class ConexionPG {

    Connection conexion = null;

    String usuario = "postgres";
    String password = "ASV30885";
    String dataBase = "gamer_pro_xela";
    String ip = "localhost";
    String puerto = "5432";

    String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + dataBase;

    public Connection getConexion() {

        try {

            Class.forName("org.postgresql.Driver");

            conexion = DriverManager.getConnection(cadena, usuario, password);

            System.out.println("Se ha conectado con la base de datos");

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos:  " + e.toString());
        }

        return conexion;
    }

}
