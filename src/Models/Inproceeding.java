package Models;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;

/**
 *
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
public class Inproceeding extends BasicDBObject {

    private ArrayList<String> author = new ArrayList();

    private String title;

    private int year;

    private String bookTitle;

    private String crossref;

    /**
     * @return ArrayList
     */
    public ArrayList<String> getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(ArrayList<String> author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Inproceeding: " + author.get(0) + " " + title + " " + year + " " + bookTitle + " " + crossref + " Fin Inproceeding \n"; //To change body of generated methods, choose Tools | Templates.
    }

}
