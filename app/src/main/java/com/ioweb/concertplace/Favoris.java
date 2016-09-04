package com.ioweb.concertplace;

/**
 * Created by Fly on 04/09/2016.
 */
public class Favoris {
    private String name;
    private int id;

    public Favoris (String favoris){
        this.name = favoris;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString (){
        return id + "\nNom favoi: " + name;
    }
}
