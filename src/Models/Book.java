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
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
@Entity("Books")
public class Book {

    @Id
    ObjectId id = new ObjectId();

    private ArrayList<String> authors = new ArrayList();

    @Reference
    private ArrayList<Author> authors_id = new ArrayList();
    private String title;
    private int year;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<Author> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(ArrayList<Author> authors_id) {
        this.authors_id = authors_id;
    }

    @Override
    public String toString() {
        return "BOOK: " + authors.get(0) + " " + title + " " + year;
    }

}
