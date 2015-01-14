package Models;

import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
@Entity("Inproceedings")
public class Inproceeding {

    @Id
    ObjectId id = new ObjectId();

    private ArrayList<String> authors = new ArrayList();

    @Reference
    private ArrayList<Author> authors_id = new ArrayList();

    private String title;

    private int year;

    private String bookTitle;

    private String crossref;

    /**
     * @return ArrayList
     */
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @param author
     */
    public void setAuthors(ArrayList<String> author) {
        this.authors = author;
    }

    /**
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return String
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param String
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return String
     */
    public String getCrossref() {
        return crossref;
    }

    /**
     *
     * @param String
     */
    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public ArrayList<Author> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(ArrayList<Author> authors_id) {
        this.authors_id = authors_id;
    }

    @Override
    public String toString() {
        return "Inproceeding: " + " " + title + " " + year + " " + bookTitle + " " + crossref + " Fin Inproceeding \n"; //To change body of generated methods, choose Tools | Templates.
    }

}
