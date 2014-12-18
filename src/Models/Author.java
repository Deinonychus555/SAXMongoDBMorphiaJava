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
 * @author Javier
 */
public class Author extends BasicDBObject {

    private String name;
    private ArrayList<String> cite = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCite() {
        return cite;
    }

    public void setCite(ArrayList<String> cite) {
        this.cite = cite;
    }

    @Override
    public String toString() {
        return "AUTHOR: " + name;
    }

}
