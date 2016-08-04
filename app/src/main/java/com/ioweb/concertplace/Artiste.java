package com.ioweb.concertplace;

import android.text.format.DateFormat;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Fly on 02/08/2016.
 */
public class Artiste {
    private String name;
    private String genre;
    private String place;
    private String city;
    private String date;

    public Artiste (String city,String place, String name, String genre, String date){
        this.city = city;
        this.place = place;
        this.name = name;
        this.genre = genre;
        this.date = date;
    }

    @Override
    public String toString() {
        return name +" à " + city + ". " + place +". " + date;
    }

    public static ArrayList<Artiste> getListOfArtistes (){
        ArrayList<Artiste> dataBase = new ArrayList<Artiste>();
        dataBase.add(new Artiste("Lyon","Transbordeaur","The Pixies","rock","01/10/2016"));
        dataBase.add(new Artiste("Lyon","Transbordeaur","AC/DC","rock","02/10/2016"));
        dataBase.add(new Artiste("Lyon","Hall Tony Garnier","Jamiroquai","rock","03/10/2016"));
        dataBase.add(new Artiste("Lyon","Hall Tony Garnier","Lanny Kravitz","rock","04/10/2016"));
        dataBase.add(new Artiste("Toulouse","Bikini","Fat Freddy","rock","07/10/2016"));
        dataBase.add(new Artiste("Toulouse","Bikini","The Wolves","rock","11/10/2016"));
        dataBase.add(new Artiste("Toulouse","ZENITH","AC/DC","rock","07/11/2016"));
        dataBase.add(new Artiste("Toulouse","ZENITH","Guns N Roses","rock","08/11/2016"));

        return dataBase;
    }

    public static ArrayList<Artiste> sortListByArtistesName () {
        ArrayList<Artiste> sortedNames = Artiste.getListOfArtistes();
        Collections.sort(sortedNames, new Comparator<Artiste>() {
            @Override
            public int compare(Artiste lhs, Artiste rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        return sortedNames;
    }
    private static ArrayList<Artiste> favoriteArtisteSchedul = new ArrayList<Artiste>();

    public static ArrayList<Artiste> getArtisteSchedul (){

        return favoriteArtisteSchedul;
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
