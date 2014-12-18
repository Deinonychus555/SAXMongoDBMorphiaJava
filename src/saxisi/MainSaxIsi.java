package saxisi;

import Models.Author;
import Models.Book;
import Models.Incollections;
import Models.Inproceeding;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            InputStream xmlInput = new FileInputStream("C:\\Users\\Javier\\Documents\\NetBeansProjects\\SAXISI\\src\\xml\\dblp.xml");
            SAXParser parser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            parser.parse(xmlInput, handler);
            System.out.println("IMPROCEEDINGS");
            for (Inproceeding inproceding : handler.getInproceedings()) {
                System.out.println(inproceding);
            }
            System.out.println("BOOKS");
            for (Book book : handler.getBooks()) {
                System.out.println(book);
            }
            System.out.println("INCOLLECTIONS");
            for (Incollections incollection : handler.getIncollections()) {
                System.out.println(incollection);
            }
            System.out.println("AUTHORS");
            for (Author author : handler.getAuthors()) {
                System.out.println(author);
            }
        } catch (Throwable err) {
            err.printStackTrace();
        }
    }

    //DB dbconnection = MongoDBConnection.getDBConnection();
//
//        DBCollection autores = dbconnection.getCollection("autores");
//        BasicDBObject autor1 = new BasicDBObject();
//        BasicDBObjectBuilder autor2 = new BasicDBObjectBuilder();
}
