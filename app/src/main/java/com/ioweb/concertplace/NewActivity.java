package com.ioweb.concertplace;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ListView listView = (ListView)findViewById(R.id.listView1);
        //String [] tab = {"Adele"};
        ArrayList<Artiste> schedulGeneral = Artiste.getSchedul();
        ArrayList<Artiste> listNames = new ArrayList<Artiste>();
        if (schedulGeneral.size()==0 || schedulGeneral.isEmpty()){
            ArrayList<Artiste> responseOfCall = Artiste.getListOfArtistes(Artiste.getTableOfArtistResearche());
            listNames = Artiste.sortListByArtistesName(responseOfCall);
        } else {
            listNames = Artiste.sortListByArtistesName(schedulGeneral);
        }


        ArrayAdapter adapter = new ArrayAdapter<Artiste>(
                    this, android.R.layout.simple_expandable_list_item_1, listNames);
        listView.setAdapter(adapter);
        //ArrayList<Artiste> listNamesSort = Artiste.sortListByArtistesName();
       /* ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_expandable_list_item_1, listNamesSort);
        listView.setAdapter(adapter1);*/



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
            Toast.makeText(getApplicationContext(), "New list ", Toast.LENGTH_SHORT).show();

            Intent update = new Intent(getApplicationContext(), NewActivity.class);
            startActivity(update);

        }

        if (id == R.id.home) {
            
            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);

        }

        return super.onOptionsItemSelected(item);
    }
}
