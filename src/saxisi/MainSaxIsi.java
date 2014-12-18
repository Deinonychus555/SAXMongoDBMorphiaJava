package saxisi;

import Connection.MongoDBConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
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
