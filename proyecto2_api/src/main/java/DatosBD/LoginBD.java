/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import Model.JsonUtil;
import Model.Usuario;
import com.mongodb.client.MongoIterable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.bson.Document;

/**
 *
 * @author MSI
 */
public class LoginBD {

    ConexionMongo conexionMongo;
    JsonUtil jsonUtil = new JsonUtil();

    public LoginBD() {
        conexionMongo = new ConexionMongo();
    }

    public String obtnerContra(String usuario) throws IOException {

        Document filtro = new Document("usuario", usuario);

        MongoIterable<Document> documents = conexionMongo.getConnection().getCollection("usuarios").find(filtro);

        if (documents.iterator().hasNext()) {

            System.out.println("\n\n\nUSUARIO ENCONTRADO_______________________________________________________");

            for (Document doc : documents) {

                Usuario userBD = (Usuario) jsonUtil.JsonStringAObjeto(doc.toJson(), Usuario.class);
                System.out.println(doc.toJson() + "\n" + userBD);
                
                return userBD.getPassword();

            }

        } 
        
        return null;
    }

}
