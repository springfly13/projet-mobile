package com.ioweb.concertplace;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Fly on 02/08/2016.
 */
public class Artiste {
    private String nameOfArtiste;
    private String country;
    private String place;
    private String city;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public static ArrayList<Artiste> getSchedul() {
        return schedul;
    }

    public static void setSchedul(ArrayList<Artiste> schedul) {
        Artiste.schedul = schedul;
    }

    //Depot de la liste generale
    private static ArrayList<Artiste> schedul = new ArrayList<Artiste>();

    public static String[] getTableOfArtistResearche() {
        return tableOfArtistResearche;
    }

    public static ArrayList<Artiste> getDepotResultOfSearch() {
        return depotResultOfSearch;
    }

    public static void setDepotResultOfSearch(ArrayList<Artiste> depotResultOfSearch) {
        Artiste.depotResultOfSearch = depotResultOfSearch;
    }

    //Depot pour stocker le resultat de recherche par lieu et par Artiste
    private static ArrayList<Artiste> depotResultOfSearch = new ArrayList<Artiste>();

    private static String tableOfArtistResearche[] = {"Zaz", "Adele", "Amir", "The Fray", "Paradis", "Sia",
            "Mika", "Maroon 5", "Mariah Carey", "Keen V", "Justin", "Justin Bieber", "Tove Lo", "Scorpions"};

    public Artiste(String name, String place, String city, String country, String date) {
        this.city = city;
        this.place = place;
        this.nameOfArtiste = name;
        this.country = country;
        this.date = date;
    }

    @Override
    public String toString() {
        return nameOfArtiste + " à " + place + ". " + city + ". " + country + ". " + date;
        //return nameOfArtiste;
    }

    public static ArrayList<Artiste> getListOfArtistes(String tabOfArtistsNames[]) {

        GetConcertRunnable runnable = new GetConcertRunnable();
        runnable.setTabOfNamesForSearch(tabOfArtistsNames);
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //schedul = runnable.dataBase;

        return runnable.getDataBase();
    }

    public static ArrayList<Artiste> sortListByArtistesName(ArrayList<Artiste> listeARanger) {
        ArrayList<Artiste> sortedNames = listeARanger;
        Collections.sort(sortedNames, new Comparator<Artiste>() {
            @Override
            public int compare(Artiste lhs, Artiste rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        return sortedNames;
    }

    //Depot du programme de concernt d'artiste favori
    private static ArrayList<Artiste> favoriteArtisteSchedul = new ArrayList<Artiste>();

    public static ArrayList<Artiste> getArtisteSchedul() {
        return favoriteArtisteSchedul;
    }

    public static ArrayList<Artiste> setArtisteSchedul(ArrayList<Artiste> listOfevents) {
        //ArrayList<Artiste> schedulOfArtist = new ArrayList<Artiste>();
        //schedulOfArtist = listOfevents;
        favoriteArtisteSchedul.clear();
        for (int i = 0; i < listOfevents.size(); i++) {
            favoriteArtisteSchedul.add(listOfevents.get(i));
        }
        //favoriteArtisteSchedul = listOfevents;
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

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return nameOfArtiste;
    }

    public void setName(String name) {
        this.nameOfArtiste = name;
    }


    public DateFormat getDayMonthYear() {
        return dayMonthYear;
    }

    public void setDayMonthYear(DateFormat dayMonthYear) {
        this.dayMonthYear = dayMonthYear;
    }


}
