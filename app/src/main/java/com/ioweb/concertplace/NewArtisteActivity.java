package com.ioweb.concertplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewArtisteActivity extends AppCompatActivity implements View.OnClickListener {

    private FavorisBDDGestion favorisToBDD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_artiste);

        Button buttonOk = (Button)findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOk:
            EditText tonEdit = (EditText)findViewById(R.id.editTextNewArtiste);
            String tonTexte = tonEdit.getText().toString();
                Favoris newFavori = new Favoris(tonTexte.toString());
                favorisToBDD = new FavorisBDDGestion (this);
                favorisToBDD.open();
                favorisToBDD.insertNewFavori(newFavori);
                favorisToBDD.close();

                //FavoriteNames.getFavoriteAsrtistes().add(new FavoriteNames(tonTexte));
                //this.finish();
                Intent intent = new Intent(this, ArtistesFavoriteActivity.class);
                startActivity(intent);

            break;
        }
    }
}
