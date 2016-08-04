package com.ioweb.concertplace;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistesFavoriteActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistes_favorite);
        ListView listView = (ListView)findViewById(R.id.listView3);

        ArrayList<FavoriteNames> listFavorite = FavoriteNames.getFavoriteAsrtistes();
        ArrayAdapter adapter1 = new ArrayAdapter<FavoriteNames>(
                this, android.R.layout.simple_expandable_list_item_1, listFavorite);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(ArtistesFavoriteActivity.this);

        Button buttonArtistesFavoriAjout = (Button)findViewById(R.id.buttonAjoutArtiste);
        buttonArtistesFavoriAjout.setOnClickListener((View.OnClickListener) this);

    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAjoutArtiste: {
                Intent intent = new Intent(this, NewArtisteActivity.class);
                startActivity(intent);
            }
            break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FavoriteNames motCle = FavoriteNames.getFavoriteAsrtistes().get(position);

        for (int i=0; i<Artiste.getListOfArtistes().size(); i++){
            if (motCle.getName().equals(Artiste.getListOfArtistes().get(i).getName())) Artiste.getArtisteSchedul().add(Artiste.getListOfArtistes().get(i));
        }

        Intent intent = new Intent(this, ArtisteFavoriteSchedulActivity.class);
        startActivity(intent);

    }
}
