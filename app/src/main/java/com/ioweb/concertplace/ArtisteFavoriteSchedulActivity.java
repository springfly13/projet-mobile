package com.ioweb.concertplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtisteFavoriteSchedulActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_artiste_favorite_schedul);
        ArrayList<Artiste> favoriteSchedul = Artiste.getArtisteSchedul();
        ListView listView = (ListView) findViewById(R.id.listView4);

        ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_expandable_list_item_1, favoriteSchedul);
        listView.setAdapter(adapter1);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favschedul, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.back) {
            Artiste.getArtisteSchedul().clear();
            Intent intentArtistes = new Intent(this, ArtistesFavoriteActivity.class);
            startActivity(intentArtistes);
        }

        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}
