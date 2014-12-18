/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import com.mongodb.BasicDBObject;



/**
 *
 * @author Javier Cañadilla
 * @author Juan Antonio Echeverrías Aranda
 * @author Oscar Miranda Bravo
 */
public class Article extends BasicDBObject{

       
    private String key;
    
    private String authors[];
    
    private String title;
  
    private int year;
    
    private String journal;
    
    public Article(){};
       
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
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
 
    
}
