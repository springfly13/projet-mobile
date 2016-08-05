package com.ioweb.concertplace;

import java.util.ArrayList;

/**
 * Created by Fly on 04/08/2016.
 */
public class FavoriteNames {

    //table name
    public static final String TABLE = "Artistes_favoris";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";

    //property to keep data
    public static int favorite_ID;
    public static String favoriteName;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FavoriteNames(String name) {
        this.name = name;
    }

    private static ArrayList<FavoriteNames> favoriteNames = new ArrayList<FavoriteNames>();

    public static ArrayList<FavoriteNames> getFavoriteAsrtistes() {
        if (favoriteNames.isEmpty()) {
            favoriteNames.add(new FavoriteNames("AC/DC"));
            favoriteNames.add(new FavoriteNames("Mika"));
        }
        return favoriteNames;
    }

    public String toString() {
        return name;
    }

    /*public static ArrayList<FavoriteNames> addNewName(String newName) {
        ArrayList<FavoriteNames> names = FavoriteNames.getFavoriteAsrtistes();
        names.add(new FavoriteNames(newName));
        return names;
    }*/
}
