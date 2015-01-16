/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxisi;

import Models.Author;
import com.mongodb.DBCursor;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Javier
 */
public class Prueba {

    public static void main(String[] args) {

        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            Morphia m = new Morphia();
            Datastore database = m.createDatastore(mongo, "BBDD_ISI");
            Query<Author> q = database.createQuery(Author.class).filter("name", "Micael Gallego");
// load the DBObject from a Mongo collection
            List<Author> asList = q.asList();

            for (Iterator<Author> iterator = asList.iterator(); iterator.hasNext();) {
                Author next = iterator.next();
                System.out.println(next.getName());
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
