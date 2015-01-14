/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author oscarmirandabravo
 */
@Entity("Incollections")
public class Incollections {

    @Id
    ObjectId id = new ObjectId();

    private ArrayList<String> authors = new ArrayList();

    @Reference
    private ArrayList<Author> authors_id = new ArrayList();

    private String title;
    private String bookTitle;
    private String crossref;
    private int year;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthor() {
        return authors;
    }

    public void setAuthor(ArrayList<String> author) {
        this.authors = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCrossef() {
        return crossref;
    }

    public void setCrossef(String crossef) {
        this.crossref = crossef;
    }

    public ArrayList<Author> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(ArrayList<Author> authors_id) {
        this.authors_id = authors_id;
    }

    @Override
    public String toString() {
        return "Incollection: " + authors.get(0) + " " + title + " " + year + " " + bookTitle + " " + crossref + " Fin incollection \n"; //To change body of generated methods, choose Tools | Templates.
    }

}
