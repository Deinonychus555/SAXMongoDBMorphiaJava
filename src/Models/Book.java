/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
public class Book {
    
    private String [] editor;
    private String [] author;
    private String title;
    private int year;

    public String[] getEditor() {
        return editor;
    }

    public void setEditor(String[] editor) {
        this.editor = editor;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
