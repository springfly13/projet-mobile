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

public class NosSuggestionsActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ListView listView = (ListView)findViewById(R.id.listView1);
        ArrayList<Artiste> schedulGeneral = Artiste.getSchedul();
        ArrayList<Artiste> listNames = new ArrayList<Artiste>();
        if (schedulGeneral.size()==0 || schedulGeneral.isEmpty()){
            ArrayList<Artiste> responseOfCall = Artiste.getListOfArtistes(Artiste.getTableOfArtistResearche());
            Artiste.setSchedul(responseOfCall);
            listNames = Artiste.sortListByArtistesName(responseOfCall);
        } else {
            listNames = Artiste.sortListByArtistesName(schedulGeneral);
        }


        ArrayAdapter adapter = new ArrayAdapter<Artiste>(
                    this, android.R.layout.simple_expandable_list_item_1, listNames);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.updateCallResponse) {

            Artiste.getSchedul().clear();
            ArrayList<Artiste> responseOfCall = Artiste.getListOfArtistes(Artiste.getTableOfArtistResearche());
            ArrayList<Artiste> listNames = Artiste.sortListByArtistesName(responseOfCall);
            Artiste.setArtisteSchedul(listNames);
            Intent update = new Intent(getApplicationContext(), NosSuggestionsActivity.class);
            startActivity(update);
            Toast.makeText(getApplicationContext(), "Reactualisation ", Toast.LENGTH_SHORT).show();

        }

        if (id == R.id.home) {

            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);

        }

        return super.onOptionsItemSelected(item);
    }
}
