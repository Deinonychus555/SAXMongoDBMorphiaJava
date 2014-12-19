/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import org.mongodb.morphia.annotations.Entity;

/**
 * @author Javier
 * @author Juan Antonio
 * @author Oscar
 */
@Entity("Books")
public class Book{

    private ArrayList<String> editor = new ArrayList();
    private ArrayList<String> author = new ArrayList();
    private String title;
    private int year;

    public ArrayList<String> getEditor() {
        return editor;
    }

    public void setEditor(ArrayList<String> editor) {
        this.editor = editor;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BOOK: " + author.get(0) + " " + title + " " + year;
    }

}
