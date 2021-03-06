// Crea una conexión a mongodb y una base de datos donde volcar los resultados.
// Crea una instancia de la clase 'SaxHandler' para parsear el xml.
// Recorre los arrays de los diferentes objetos creados.
// Se añaden las referencias oportunas a otros objetos.
// Se guardan los objetos como documentos en mongo.



package saxisi;

import Models.Article;
import Models.Author;
import Models.BoehmAuthor;
import Models.Book;
import Models.EditorAuthor;
import Models.ImportantAuthor;
import Models.InadecuateAuthor;
import Models.Incollections;
import Models.Inproceeding;
import Models.SociableAuthor;
import Models.StableAuthor;
import Models.TravellerAuthor;
import Models.UnproductiveAuthor;
import com.mongodb.MongoClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
            Datastore database = m.createDatastore(mongo, "BBDD_ISI_BOEHM");

            InputStream xmlInput = new FileInputStream("/home/juanan/NetBeansProjects/SAXMongoDBMorphiaJava/src/xml/prueba.xml");
            SAXParser parser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            parser.parse(xmlInput, handler);

            System.out.println("INPROCEEDINGS");
            for (Inproceeding inproceeding : handler.getInproceedings()) {
                for (String author : inproceeding.getAuthors()) {
                    Author author_obj = handler.getAuthors().get(author);
                    if (author_obj != null) {
                        author_obj.getInproceedings().add(inproceeding);
                        inproceeding.getAuthors_id().add(author_obj);
                        author_obj.setMin_year((inproceeding.getYear() < author_obj.getMin_year()) ? inproceeding.getYear() : author_obj.getMin_year());
                        author_obj.setMax_year((inproceeding.getYear() > author_obj.getMax_year()) ? inproceeding.getYear() : author_obj.getMax_year());
                    }
                }
                database.save(inproceeding);
            }

            System.out.println("BOOKS");
            for (Book book : handler.getBooks()) {
                for (String author : book.getAuthor()) {
                    Author author_obj = handler.getAuthors().get(author);
                    if (author_obj != null) {
                        author_obj.getBooks().add(book);
                        book.getAuthors_id().add(author_obj);
                        author_obj.setMin_year((book.getYear() < author_obj.getMin_year()) ? book.getYear() : author_obj.getMin_year());
                        author_obj.setMax_year((book.getYear() > author_obj.getMax_year()) ? book.getYear() : author_obj.getMax_year());
                    }
                }
                database.save(book);
            }

            System.out.println("INCOLLECTIONS");
            for (Incollections incollection : handler.getIncollections()) {
                for (String author : incollection.getAuthor()) {
                    Author author_obj = handler.getAuthors().get(author);
                    if (author_obj != null) {
                        author_obj.getIncollections().add(incollection);
                        incollection.getAuthors_id().add(author_obj);
                        author_obj.setMin_year((incollection.getYear() < author_obj.getMin_year()) ? incollection.getYear() : author_obj.getMin_year());
                        author_obj.setMax_year((incollection.getYear() > author_obj.getMax_year()) ? incollection.getYear() : author_obj.getMax_year());
                    }
                }
                database.save(incollection);
            }

            System.out.println("ARTICLES");
            for (Article article : handler.getArticles()) {
                for (String author : article.getAuthors()) {
                    Author author_obj = handler.getAuthors().get(author);
                    if (author_obj != null) {
                        author_obj.getArticle().add(article);
                        article.getAuthors_id().add(author_obj);
                        author_obj.setMin_year((article.getYear() < author_obj.getMin_year()) ? article.getYear() : author_obj.getMin_year());
                        author_obj.setMax_year((article.getYear() > author_obj.getMax_year()) ? article.getYear() : author_obj.getMax_year());
                    }
                }
                database.save(article);
            }

            System.out.println("AUTHORS");
            for (Author author : handler.getAuthors().values()) {
                database.save(author);
                ArrayList repetidos = new ArrayList<Author>();

                if (!author.isNobel() && !author.isOccasional()) {
                    ImportantAuthor ia = new ImportantAuthor(author);
                    database.save(ia);

                    if (ia.getIndiceSexenios() > 2) {
                        if (ia.isInadequate()) {
                            InadecuateAuthor inadecuateAuthor = new InadecuateAuthor(author);
                            database.save(inadecuateAuthor);
                        } else if (ia.isInproductive()) {
                            UnproductiveAuthor unproductiveAuthor = new UnproductiveAuthor(author);
                            database.save(unproductiveAuthor);
                        } else if (ia.isTraveller()) {
                            TravellerAuthor travellerAuthor = new TravellerAuthor(author);
                            database.save(travellerAuthor);
                        } else if (ia.isEditor()) {
                            EditorAuthor editorAuthor = new EditorAuthor(author);
                            database.save(editorAuthor);
                        }
                    }
                    if (ia.isSociable()) {
                        SociableAuthor sociableAuthor = new SociableAuthor(author);
                        database.save(sociableAuthor);
                    } else if (ia.isEstable()) {
                        StableAuthor stableAuthor = new StableAuthor(author);
                        database.save(stableAuthor);
                    }
                    if (author.bohem(0, repetidos) <= 4) {
                        BoehmAuthor boehm = new BoehmAuthor(author.getName());
                        database.save(boehm);
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException err) {
            err.printStackTrace();
        }
    }

//        DBCollection autores = dbconnection.getCollection("autores");
//        BasicDBObject autor1 = new BasicDBObject();
//        BasicDBObjectBuilder autor2 = new BasicDBObjectBuilder();
}
