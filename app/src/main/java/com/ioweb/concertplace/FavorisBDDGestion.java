package com.ioweb.concertplace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fly on 04/09/2016.
 */
public class FavorisBDDGestion {
    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }

    private SQLiteDatabase database;
    private MaBaseSQL dbHelper;
    private String[] allCollumns = {MaBaseSQL.COL_ID, MaBaseSQL.COL_NAME};

    public FavorisBDDGestion (Context context){
        dbHelper = new MaBaseSQL(context,"favoris_table",null,1);
        this.openToWrite();
    };

    public void openToWrite() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void openToRead() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public Cursor getFavorisList(){
        if(database != null){
            return database.rawQuery(" SELECT * FROM " + MaBaseSQL.TABLE_FAVORIS, null );
        }
        return null;
    }

    public void insertNewFavori(Favoris newFavori){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MaBaseSQL.COL_NAME, newFavori.getName());
        database.insert(MaBaseSQL.TABLE_FAVORIS,null,contentValues);
    }




    public Favoris createFavoriName(String nomArtiste){
        ContentValues values = new ContentValues();
        values.put(MaBaseSQL.COL_NAME, nomArtiste);
        long insertId = database.insert(MaBaseSQL.TABLE_FAVORIS, null, values);
        Cursor cursor = database.query(MaBaseSQL.TABLE_FAVORIS,allCollumns, MaBaseSQL.COL_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Favoris newFavori = cursorToComment(cursor);
        cursor.close();
        return newFavori;
    }

    public void deleteFavori (Favoris nom){
        long id = nom.getId();
        System.out.println("Nom favori a ete supprime avec le numero : " + id);
        database.delete(MaBaseSQL.TABLE_FAVORIS, MaBaseSQL.COL_ID + " = " + id, null);
    }

    public List<Favoris> getAllFavoris(){
        List<Favoris> favorisList = new ArrayList<Favoris>();
        Cursor cursor = database.query(MaBaseSQL.TABLE_FAVORIS, allCollumns,null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Favoris favoris = cursorToComment(cursor);
            favorisList.add(favoris);
            cursor.moveToNext();
        }
        cursor.close();
        return favorisList;
    }

    private Favoris cursorToComment(Cursor cursor) {
        Favoris favoris = new Favoris();
        favoris.setId(cursor.getLong(0));
        favoris.setName(cursor.getString(1));
        return favoris;
    }



}
