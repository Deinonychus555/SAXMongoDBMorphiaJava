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
    
    private int year;
    
    private String journal;
    
    
    public Article(){};
    
    public Article (String key, String authors[], int year, String journal){
        
        this.key=key;
        this.year=year;
        this.journal=journal;
        System.arraycopy(authors, 0, this.authors, 0, authors.length);
    };
    
}
