/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxisi;

import Connection.MongoDBConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 *
 * @author Javier
 */
public class MainSaxIsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DB dbconnection = MongoDBConnection.getDBConnection();

        DBCollection autores = dbconnection.getCollection("autores");
        BasicDBObject autor1 = new BasicDBObject();
        BasicDBObjectBuilder autor2 = new BasicDBObjectBuilder();

    }

}
