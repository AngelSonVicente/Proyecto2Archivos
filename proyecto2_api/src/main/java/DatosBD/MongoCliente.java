/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosBD;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoIterable;

/**
 *
 * @author angel
 */
public class MongoCliente {
        private MongoClient mongoClient;

    public MongoCliente() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
    

    public MongoIterable<String> getAllDatabases() {
        return mongoClient.listDatabaseNames();
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    
}
