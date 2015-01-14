/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Javier
 */
@Entity("Authors")
public class Author {

    @Id
    ObjectId id = new ObjectId();

    private String name;

    @Reference
    private ArrayList<Incollections> incollections = new ArrayList();

    @Reference
    private ArrayList<Book> books = new ArrayList();

    @Reference
    private ArrayList<Inproceeding> inproceedings = new ArrayList();

    @Reference
    private ArrayList<Article> article = new ArrayList();

    private int min_year = 100000000;
    private int max_year = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<Incollections> getIncollections() {
        return incollections;
    }

    public void setIncollections(ArrayList<Incollections> incollections) {
        this.incollections = incollections;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Inproceeding> getInproceedings() {
        return inproceedings;
    }

    public void setInproceedings(ArrayList<Inproceeding> inproceedings) {
        this.inproceedings = inproceedings;
    }

    public ArrayList<Article> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<Article> article) {
        this.article = article;
    }

    public int getMax_year() {
        return max_year;
    }

    public void setMax_year(int max_year) {
        this.max_year = max_year;
    }

    public int getMin_year() {
        return min_year;
    }

    public void setMin_year(int min_year) {
        this.min_year = min_year;
    }

    @Override
    public String toString() {
        return "AUTHOR: " + name;
    }

}
