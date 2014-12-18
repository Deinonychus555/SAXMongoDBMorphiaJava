/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;

/**
 *
 * @author Javier Cañadilla
 * @author Juan Antonio Echeverrías Aranda
 * @author Oscar Miranda Bravo
 */
public class Article extends BasicDBObject {

    private String key;

    private ArrayList<String> authors = new ArrayList();

    private String title;

    private int year;

    private String journal;

    private String crossref;

    public Article() {
    }

    ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList getAuthors() {
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

}
