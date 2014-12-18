/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author oscarmirandabravo
 */
public class Incollections {
    
    private String [] author;
    private String title;
    private String bookTitle;
    private String crossef;
    private int año;

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
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
        return crossef;
    }

    public void setCrossef(String crossef) {
        this.crossef = crossef;
    }
    
    
    
    
}
