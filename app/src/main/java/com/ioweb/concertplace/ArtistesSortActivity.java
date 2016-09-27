package com.ioweb.concertplace;

import android.content.Intent;

        import android.graphics.Color;

        import android.support.v7.app.AppCompatActivity;

        import android.os.Bundle;

        import android.view.View;

        import android.view.Window;

        import android.widget.AdapterView;

        import android.widget.AdapterView.OnItemSelectedListener;

        import android.widget.ArrayAdapter;

        import android.widget.Button;

        import android.widget.Spinner;

        import android.widget.TextView;

        import android.widget.Toast;

        import android.app.Activity;

        import java.util.List;

        import java.util.ArrayList;

public class ArtistesSortActivity extends AppCompatActivity {    // premier spinner

    private Spinner spinner;

    private String spinner_value = "";    // deuxième spinner

    private Spinner spinner2;

    private String spinner_value2 = "";    public void main(String[] args) {

        // Creation d'une nouvelle ArrayList.

        // Spinner Drop down elements

        List<String> categories = new ArrayList<String>();

        categories.add("");

        categories.add("AC/DC");

        categories.add("Fat_Freddy");

        categories.add("Guns_N_Roses");

        categories.add("Jamiroquai");

        categories.add("Lenny_Kravitz");

        categories.add("The_Pixies");

        categories.add("The_Wolves");        // Deuxième Spinner Drop down elements

        List<String> categories2 = new ArrayList<String>();

        categories2.add("");

        categories2.add("Lyon");

        categories2.add("Toulouse");        // Creating adapter for first spinner

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner

        spinner.setAdapter(dataAdapter);        // deuxième spinner

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        spinner2.setBackgroundResource(R.color.black);

        // Creating adapter for second spinner

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner

        // spinner2.setAdapter(dataAdapter2);

        spinner2.setAdapter(dataAdapter2);

        spinner2.setPrompt("Select Driver");

    }    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_artistes_sort);

    }    public void onClickB1(View view) {

        Intent intent = new Intent(ArtistesSortActivity.this, ConcertsPerArtistActivity.class);

        startActivity(intent);

    }    public void onClickB2(View view) {

        Intent intent = new Intent(ArtistesSortActivity.this, ConcertsPerLieuActivity.class);

        startActivity(intent);

    }

       /*

       String concertArtist = String.valueOf(spinner.getSelectedItem());

       String concertLieu = String.valueOf(spinner2.getSelectedItem());*/        /*

       Button buttonChoose_artist = (Button) findViewById(R.id.choose_artist);

       buttonChoose_artist.setOnClickListener(this); */        /*

       Button buttonChoose_lieu = (Button) findViewById(R.id.choose_lieu);

       buttonChoose_lieu.setOnClickListener(this); */

}