package Connection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
public class MongoDBConnection {

    static DB dbconnection;

    public MongoDBConnection() {
        dbconnection = getDBConnection();
    }

    public static DB getDBConnection() {
        if (dbconnection == null) {
            try {
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                dbconnection = mongoClient.getDB("PracticaISI");
            } catch (UnknownHostException ex) {
                Logger.getLogger(MongoDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dbconnection;
    }

}
