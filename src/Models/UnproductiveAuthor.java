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
 * @author Javier
 */
@Entity("UnproductiveAuthor")
public class UnproductiveAuthor {

    public UnproductiveAuthor(Author author) {
        this.id = author.id;
        this.name = author.name;
        this.articles = (ArrayList<Article>) author.articles.clone();
        this.books = (ArrayList<Book>) author.books.clone();
        this.incollections = (ArrayList<Incollections>) author.incollections;
        this.inproceedings = (ArrayList<Inproceeding>) author.inproceedings.clone();
        this.max_year = author.max_year;
        this.min_year = author.min_year;
    }

    @Id
    ObjectId id = new ObjectId();

    protected String name;

    @Reference
    protected ArrayList<Incollections> incollections = new ArrayList();

    @Reference
    protected ArrayList<Book> books = new ArrayList();

    @Reference
    protected ArrayList<Inproceeding> inproceedings = new ArrayList();

    @Reference
    protected ArrayList<Article> articles = new ArrayList();

    protected int min_year = 100000000;
    protected int max_year = 0;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public int getMin_year() {
        return min_year;
    }

    public void setMin_year(int min_year) {
        this.min_year = min_year;
    }

    public int getMax_year() {
        return max_year;
    }

    public void setMax_year(int max_year) {
        this.max_year = max_year;
    }

    public int getArticlesByYear(int year) {
        int contador = 0;
        for (Article article : this.articles) {
            if (article.getYear() == year) {
                contador++;
            }
        }
        return contador;
    }

    public int getInproceedingsByYear(int year) {
        int contador = 0;
        for (Inproceeding inproceeding : this.inproceedings) {
            if (inproceeding.getYear() == year) {
                contador++;
            }
        }
        return contador;
    }

    public int getIndiceSexenios() {
        int min_year = this.min_year;
        int max_year = this.max_year;
        int sexenios = 0;
        int contador = 1;
        int num_articles = 0;
        int num_inproceedings = 0;
        if ((max_year - min_year) >= 12) {
            while (min_year <= max_year + 1) {
                if (contador <= 6) {
                    num_articles = this.getArticlesByYear(min_year);
                    num_inproceedings = this.getInproceedingsByYear(min_year);
                    contador++;
                    min_year++;
                } else {
                    if (num_articles > 3 || (num_articles + num_inproceedings > 6)) {
                        sexenios++;
                    }
                    contador = 1;
                }
            }
        }
        return sexenios;
    }

}
