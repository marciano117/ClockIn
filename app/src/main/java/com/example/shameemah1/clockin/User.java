package com.example.shameemah1.clockin;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JJ on 11/22/2016.
 */

public class User implements Serializable{

    private int id;
    private String username;
    private String password;
    private int level; //0 = admin; 1 = user
    public ArrayList<String> punches;

    public User(int id, String username, String password, int level) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.punches = new ArrayList<String>();
    }

    public User(int id){
        this.id = id;
    }
    //getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUser() {
        return username;
    }
    public void setUser(String username) {
        this.username = username;
    }
    public String getPass() {
        return password;
    }
    public void setPass(String password) {this.password = password;}
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }

    @Override
    public String toString() {
        return "User [id= " + id + ", Username= " + username + ", Password= "
                + password + ", Level= "+level+"]";
    }
}