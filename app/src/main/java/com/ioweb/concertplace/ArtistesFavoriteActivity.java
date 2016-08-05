package com.ioweb.concertplace;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtistesFavoriteActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistes_favorite);
        final ListView listView = (ListView)findViewById(R.id.listView3);
        listView.setEmptyView(findViewById(R.id.empty));

       // utilisation de la base de donner


       /*FavoriManager fm = new FavoriManager(this);
        fm.open();
        String [] from = new String[] {DBHelper.}
        Cursor cursor = fm.fetch();*/

        ///utilisation de la liste locale
       // final ArrayList<FavoriteNames> listFavorite = FavoriteNames.getFavoriteAsrtistes();
        FavoriManager fm = new FavoriManager(this);
        final ArrayList<FavoriteNames> listFavorite = fm.getFavoriteNamesList();

        final ArrayAdapter adapter1 = new ArrayAdapter<FavoriteNames>(
                this, android.R.layout.simple_expandable_list_item_1, listFavorite);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(ArtistesFavoriteActivity.this);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                listFavorite.remove(arg2);
                ArrayAdapter adapter = new ArrayAdapter<FavoriteNames>(ArtistesFavoriteActivity.this, android.R.layout.simple_expandable_list_item_1, listFavorite);
                listView.setAdapter(adapter);
                //Toast.makeText(this, "Vous avez supprimé un nom", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

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

        if (Artiste.getArtisteSchedul().isEmpty()) Toast.makeText(this, "Cet artiste n'a pas des concernts prochainement", Toast.LENGTH_SHORT).show();
        else {
        Intent intent = new Intent(this, ArtisteFavoriteSchedulActivity.class);
        startActivity(intent);}


    }
}
