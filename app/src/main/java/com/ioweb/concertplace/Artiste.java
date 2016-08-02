package com.ioweb.concertplace;

import android.text.format.DateFormat;

/**
 * Created by Fly on 02/08/2016.
 */
public class Artiste {
    private String name;
    private String genre;
    private String place;
    private String city;

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
