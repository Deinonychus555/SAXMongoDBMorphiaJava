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
 * @author oscarmirandabravo
 */
public class Incollections extends BasicDBObject {

    private ArrayList<String> author = new ArrayList();
    private String title;
    private String bookTitle;
    private String crossref;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<String> author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Incollection: " + author.get(0) + " " + title + " " + year + " " + bookTitle + " " + crossref + " Fin incollection \n"; //To change body of generated methods, choose Tools | Templates.
    }

}
