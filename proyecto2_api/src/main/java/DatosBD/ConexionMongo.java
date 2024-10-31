/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;

/**
 *
 * @author angel
 */
public class ConexionMongo {

    private String servidor = "localhost";
    private String dbName = "grafiles";

    MongoClient mongo = null;

    MongoDatabase ConexionBD;

    int puerto = 27017;

    public ConexionMongo() {

        try {
                                            //si  es en local usar localhost, sino mongodb
            mongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        } catch (MongoException e) {

            e.printStackTrace();

        }

    }

    public MongoDatabase getConnection() {

        return mongo.getDatabase(dbName);

    }
    
    public MongoClient getMongoCliet(){
    
        return mongo;
    
    }

}
