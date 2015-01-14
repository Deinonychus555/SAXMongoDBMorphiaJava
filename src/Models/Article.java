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
 * @author Javier Cañadilla
 * @author Juan Antonio Echeverrías Aranda
 * @author Oscar Miranda Bravo
 */
@Entity("Articles")
public class Article {

    @Id
    ObjectId id = new ObjectId();

    private String key;

    private ArrayList<String> authors = new ArrayList();

    @Reference
    private ArrayList<Author> authors_id = new ArrayList();

    private String title;

    private int year;

    private String journal;

    private String crossref;

    public Article() {
    }

    ;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
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

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public ArrayList<Author> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(ArrayList<Author> authors_id) {
        this.authors_id = authors_id;
    }

}
