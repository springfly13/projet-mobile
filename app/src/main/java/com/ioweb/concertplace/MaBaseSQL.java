package com.ioweb.concertplace;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fly on 04/09/2016.
 */
public class MaBaseSQL extends SQLiteOpenHelper {
    private static final String TABLE_FAVORIS = "table_favoris";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "Name";

    private static final String CREATE_BDD = " CREATE TABLE " + TABLE_FAVORIS + " ( "
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL); ";

    public MaBaseSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super (context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(" DROP TABLE " + TABLE_FAVORIS + " ; ");
        onCreate(db);
    }
}
