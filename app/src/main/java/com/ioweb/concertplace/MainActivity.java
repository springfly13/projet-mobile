package com.ioweb.concertplace;

import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Artiste> list ;

    Bundle bundle;
    String maValeur;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAllArtistes = (Button)findViewById(R.id.button5);
        buttonAllArtistes.setOnClickListener( this);

        Button buttonTriArtistes = (Button)findViewById(R.id.buttonArtistes);
        buttonTriArtistes.setOnClickListener((View.OnClickListener) this);

       /*Button buttonArtistesResearche = (Button)findViewById(R.id.button4);
        buttonTriArtistes.setOnClickListener((View.OnClickListener) this);*/

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
            {Intent intent = new Intent(this, NewActivity.class);
                startActivity(intent);}
                break;
            /*case R.id.button4:
            {Intent intentArtistesSearch = new Intent(this, ArtistesSearcheActivity.class);
                startActivity(intentArtistesSearch);}
                break;*/
            case R.id.buttonArtistes:
            {Intent intentArtistes = new Intent(this, ArtistesSortActivity.class);
                startActivity(intentArtistes);}
                break;
        }

    }


    public void onClickArtistes(View v) {
        Intent intentArtistes = new Intent(this, ArtistesSortActivity.class);
        startActivity(intentArtistes);
    }
}
