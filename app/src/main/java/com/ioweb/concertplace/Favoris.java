package com.ioweb.concertplace;

/**
 * Created by Fly on 04/09/2016.
 */
public class Favoris {
    private String name;
    private long id;

    public Favoris(){return;}

    public Favoris (String favoris){
        this.name = favoris;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString (){
        return id + "\nNom favoi: " + name;
    }
}
