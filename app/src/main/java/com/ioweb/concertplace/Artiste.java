package com.ioweb.concertplace;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fly on 02/08/2016.
 */
public class Artiste {
    private String name;
    private String genre;
    private String place;
    private String city;

    public Artiste (String city,String place, String name, String genre){
        this.city = city;
        this.place = place;
        this.name = name;
        this.genre = genre;
        //this.date = date;
    }

    public static ArrayList<Artiste> getListOfArtistes (){
        ArrayList<Artiste> dataBase = new ArrayList<Artiste>();
        dataBase.add(new Artiste("Lyon","Transbordeaur","The Pixies","rock"));
        dataBase.add(new Artiste("Lyon","Transbordeaur","AC/DC","rock"));
        dataBase.add(new Artiste("Lyon","Hall Tony Garnier","Jamiroquai","rock"));
        dataBase.add(new Artiste("Lyon","Hall Tony Garnier","Lanny Kravitz","rock"));
        dataBase.add(new Artiste("Toulouse","Bikini","Fat Freddy","rock"));
        dataBase.add(new Artiste("Toulouse","Bikini","The Wolves","rock"));
        dataBase.add(new Artiste("Toulouse","ZENITH","AC/DC","rock"));
        dataBase.add(new Artiste("Toulouse","ZENITH","Guns N Roses","rock"));

        return dataBase;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private DateFormat dayMonthYear;


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public DateFormat getDayMonthYear() {
        return dayMonthYear;
    }

    public void setDayMonthYear(DateFormat dayMonthYear) {
        this.dayMonthYear = dayMonthYear;
    }






}
