package com.ioweb.concertplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fly on 05/08/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
//nom de la base de données
    private static final String DB_NAME = "Artistes_favoris.db";
    private static final int DB_VERSION = 1;
    public static SQLiteDatabase db ;

    /*private static DBHelper sInstance;

    public static synchronized DBHelper getsInstance (Context context){
        if (sInstance == null) {
            sInstance = new DBHelper(context);
        }
        return sInstance;
    }*/

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String CREAT_TABLE_ARTISTES = " CREATE TABLE " + FavoriteNames.TABLE
               + " ( "
               +FavoriteNames.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL "
               +FavoriteNames.KEY_NAME + " TEXT NOT NULL ) ";
        /*String CREAT_TABLE_ARTISTES = " CREATE TABLE " + FavoriteNames.TABLE
                + " ( " +FavoriteNames.KEY_NAME + " TEXT NOT NULL ) ";*/
// CREATE TABLE favorites (id INTEGER PRIMARY KEY, name TEXT)
        db.execSQL(CREAT_TABLE_ARTISTES);
        insertArtiste(db, "AC/DC");
        insertArtiste(db, "Amir");
        //db.execSQL(FavoriManager.CREAT_TABLE_ARTISTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + FavoriteNames.TABLE);
        onCreate(db);

    }

    private static void insertArtiste (SQLiteDatabase db, String name){
        ContentValues nameValue = new ContentValues();
        nameValue.put (FavoriteNames.KEY_NAME, name);
        db.insert(FavoriteNames.KEY_NAME, null, nameValue);

    }

}
