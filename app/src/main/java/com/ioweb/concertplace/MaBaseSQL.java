package com.ioweb.concertplace;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fly on 04/09/2016.
 */
public class MaBaseSQL extends SQLiteOpenHelper {
    public static final String TABLE_FAVORIS = "table_favoris";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Name";

    private static final String DATABASE_NAME = "favoris.db";
    private static final int DATABASE_VERSION = 1;

    //database creation statement
//utiliser DATABASE_CREATE à la place de CREATE_BDD ?
    private static final String createBDD = " CREATE TABLE " + TABLE_FAVORIS + " ( "
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL ); ";

    public MaBaseSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, DATABASE_VERSION);
    }
    /*public MaBaseSQL (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }*/



    /*public MaBaseSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super (context, name, factory, version);
    }*/



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createBDD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(" DROP TABLE " + TABLE_FAVORIS + " ; ");
        onCreate(db);
    }
}
