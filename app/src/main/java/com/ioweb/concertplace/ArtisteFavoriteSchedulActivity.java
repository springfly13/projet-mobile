package com.ioweb.concertplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtisteFavoriteSchedulActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artiste_favorite_schedul);
        ArrayList<Artiste> favoriteSchedul = Artiste.getArtisteSchedul();
        ListView listView = (ListView)findViewById(R.id.listView4);
        //if (favoriteSchedul.isEmpty()) Toast.makeText(this, "Cet artiste n'a pas des concernts prochainement", Toast.LENGTH_SHORT).show();
        //else {
         ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_expandable_list_item_1, favoriteSchedul);
        listView.setAdapter(adapter1);
    //}

        Button buttonAccueil = (Button)findViewById(R.id.buttonAccueil);
        buttonAccueil.setOnClickListener((View.OnClickListener) this);

        Button buttonArtistesFavori = (Button)findViewById(R.id.buttonBack);
        buttonArtistesFavori.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAccueil:
            {Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);}
            break;

            case R.id.buttonBack:
            {Artiste.getArtisteSchedul().clear();
                Intent intentArtistes = new Intent(this, ArtistesFavoriteActivity.class);
                startActivity(intentArtistes);}
            break;

        }

    }
}
