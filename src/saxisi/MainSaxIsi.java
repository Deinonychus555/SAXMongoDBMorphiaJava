package saxisi;

import Connection.MongoDBConnection;
import Models.Author;
import Models.Book;
import Models.Incollections;
import Models.Inproceeding;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.xml.sax.SAXException;

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
//        DB dbconnection = MongoDBConnection.getDBConnection();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            Morphia m = new Morphia();
            Datastore database = m.createDatastore(mongo, "PracticaISI");

            InputStream xmlInput = new FileInputStream("C:\\Users\\Javier\\Documents\\NetBeansProjects\\sax_isi\\src\\xml\\dblp.xml");
            SAXParser parser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            parser.parse(xmlInput, handler);
            System.out.println("IMPROCEEDINGS");
            for (Inproceeding inproceeding : handler.getInproceedings()) {
//                DBCollection inproceedings = dbconnection.getCollection("inproceedings");
                database.save(inproceeding);
            }
            System.out.println("BOOKS");
            for (Book book : handler.getBooks()) {
//                DBCollection books = dbconnection.getCollection("books");
                database.save(book);
            }
            System.out.println("INCOLLECTIONS");
            for (Incollections incollection : handler.getIncollections()) {
//                DBCollection incollections = dbconnection.getCollection("incollections");
                database.save(incollection);
            }
            System.out.println("AUTHORS");
            for (Author author : handler.getAuthors()) {
                //DBCollection authors = dbconnection.getCollection("authors");
                //authors.save(author);

                database.save(author);
            }
        } catch (ParserConfigurationException | SAXException | IOException err) {
            err.printStackTrace();
        }
    }

//        DBCollection autores = dbconnection.getCollection("autores");
//        BasicDBObject autor1 = new BasicDBObject();
//        BasicDBObjectBuilder autor2 = new BasicDBObjectBuilder();
}
