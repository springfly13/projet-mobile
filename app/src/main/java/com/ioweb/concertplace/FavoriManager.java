package com.ioweb.concertplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Fly on 05/08/2016.
 */
public class FavoriManager {

    private  DBHelper dbHelper;
    public  SQLiteDatabase db;

    public FavoriManager (Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(FavoriteNames favoriteNames) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FavoriteNames.KEY_NAME, FavoriteNames.favoriteName);
        //Insertion of Row
        long favorite_ID = db.insert(FavoriteNames.TABLE, null, values);
        db.close(); //Closing database connection
        return (int) favorite_ID;

    }
    public void update (FavoriteNames favoriteNames) {
        //Open connection to write data
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FavoriteNames.KEY_NAME, FavoriteNames.favoriteName);
        db.update(FavoriteNames.TABLE,values,FavoriteNames.KEY_ID + " = ?", new String [] {String.valueOf(FavoriteNames.favorite_ID)});
        db.close(); //Closing database connection
    }

    public  ArrayList<FavoriteNames> getFavoriteNamesList(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //String selectQuery = "SELECT " + FavoriteNames.KEY_ID + " , " + FavoriteNames.KEY_NAME + " FROM " + FavoriteNames.TABLE;
        String selectQuery = " SELECT " + FavoriteNames.KEY_ID + "  " + FavoriteNames.KEY_NAME + " FROM " + FavoriteNames.TABLE;
        ArrayList<FavoriteNames> nameList = new ArrayList<FavoriteNames>();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                nameList.add(new FavoriteNames(cursor.getString(cursor.getColumnIndex(FavoriteNames.KEY_NAME))));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nameList;
    }

   /* public void open () {
        db = dbHelper.getWritableDatabase();
    }

    public void close (){
        db.close();
    }*/

   /* public long addFavoriArtiste (FavoriteNames artiste){
        ContentValues value = new ContentValues();
        value.put(KEY_NOM_ARTISTE,artiste.getName() );
        return db.insert(TABLE_NAME, null, value);
    }*/


    public void deleteName (int favorite_Id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(FavoriteNames.TABLE,FavoriteNames.KEY_ID + " = ? ", new String [] {String.valueOf(favorite_Id)});
        db.close();

    }

    /*public FavoriteNames getFavoriArtiste (int id){
        FavoriteNames fn = new FavoriteNames(" ");
        Cursor c = db.rawQuery ("SELECT*FROM "+ TABLE_NAME+" WHERE "+ KEY_NOM_ARTISTE + "= "+ id,null);
        if (c.moveToFirst()){
            fn.setName(c.getString(c.getColumnIndex(KEY_NOM_ARTISTE)));
            c.close();
        }
        return fn;
    }

    public Cursor getArtistes () {
        return db.rawQuery("SELECT*FROM " + TABLE_NAME,null);
    }*/



}
