package com.ioweb.concertplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ResearcheByArtistByCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concerts_per_artist);
        ListView listView = (ListView) findViewById(R.id.listView2);
        // String nameForSearch =
        ArrayList<Artiste> listNamesSort = Artiste.getDepotResultOfSearch();
        ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_list_item_1, listNamesSort);
        listView.setAdapter(adapter1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searche, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.home) {

            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);

        }

        return super.onOptionsItemSelected(item);
    }

}
