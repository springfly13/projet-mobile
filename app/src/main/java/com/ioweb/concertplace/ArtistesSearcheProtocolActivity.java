package com.ioweb.concertplace;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.view.Window;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class ArtistesSearcheProtocolActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton;
    EditText mEdit;

    public String getSelectedArtist() {
        return selectedArtist;
    }

    public void setSelectedArtist(String selectedArtist) {
        this.selectedArtist = selectedArtist;
    }

    private String selectedArtist = "";

    public String getSelectedArtistCity() {
        return selectedArtistCity;
    }

    public void setSelectedArtistCity(String selectedArtistCity) {
        this.selectedArtistCity = selectedArtistCity;
    }

    private String selectedArtistCity = "";

    public ArrayList<Artiste> getListeOfAllEvents() {
        return listeOfAllEvents;
    }

    public void setListeOfAllEvents(ArrayList<Artiste> listeOfAllEvents) {
        this.listeOfAllEvents = listeOfAllEvents;
    }

    private ArrayList<Artiste> listeOfAllEvents = new ArrayList<Artiste>();

    public String getNameOfArtist() {
        return nameOfArtist;
    }

    public void setNameOfArtist(String nameOfArtist) {
        this.nameOfArtist = nameOfArtist;
    }

    private String nameOfArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_artistes_sort);

        //Recuperation de la liste pour la recherche
        listeOfAllEvents = Artiste.getSchedul();
        if (listeOfAllEvents.isEmpty() || listeOfAllEvents.size() == 0) {
            listeOfAllEvents = Artiste.getListOfArtistes(Artiste.getTableOfArtistResearche());
            Artiste.setSchedul(listeOfAllEvents);
        }
        //recherche avec l'input du nome d'artiste

        mButton = (Button) findViewById(R.id.textInputOk);
        mEdit = (EditText) findViewById(R.id.nameOfArtist);



        // Recherche par nome d'artist et ville avec les spinneurs
        // Spinner Drop down elements
        String tabOfSpinerItems[] = Artiste.getTableOfArtistResearche();
        List<String> artists = new ArrayList<String>(Arrays.asList(tabOfSpinerItems));
        artists.add(0, "");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, artists);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                setSelectedArtist(parent.getItemAtPosition(pos).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing, just another required interface callback
            }

        });

        // deuxième spinner

        List<String> artistsCity = new ArrayList<String>();
        artistsCity.add(listeOfAllEvents.get(0).getCity());
        for (int i = 1; i < listeOfAllEvents.size(); i++) {
            if (!listeOfAllEvents.get(i).getCity().equals(listeOfAllEvents.get(i - 1).getCity())) {
                artistsCity.add(listeOfAllEvents.get(i).getCity());
            }
        }

        artistsCity.add(0, "");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, artistsCity);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(dataAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                setSelectedArtistCity(parent.getItemAtPosition(pos).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing, just another required interface callback
            }

        });

        Button buttonChooseArtist = (Button) findViewById(R.id.choose_artist);
        buttonChooseArtist.setOnClickListener(this);

        Button buttonInputTextOk = (Button) findViewById(R.id.textInputOk);
        buttonInputTextOk.setOnClickListener(this);

        Button buttonChooseArtistCity = (Button) findViewById(R.id.choose_lieu);
        buttonChooseArtistCity.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String selectedItem = "";
        switch (view.getId()) {
            case R.id.textInputOk: {
                Log.v("EditText", mEdit.getText().toString());
                selectedItem = mEdit.getText().toString();

                if ( !selectedItem.isEmpty()) {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "Vous avez entre : " + selectedItem, Toast.LENGTH_SHORT).show();
                    ArrayList<Artiste> tab = new ArrayList<Artiste>();
                    for (int i = 0; i < listeOfAllEvents.size(); i++) {
                        if (listeOfAllEvents.get(i).getName().equals(selectedItem)) {
                            tab.add(listeOfAllEvents.get(i));
                        }
                    }
                    if (tab.size() == 0 || tab.isEmpty()) {
                        String[] tab2 = {selectedItem};
                        tab = Artiste.getListOfArtistes(tab2);

                    }
                    Artiste.getDepotResultOfSearch().clear();
                    Artiste.setDepotResultOfSearch(tab);
                    Intent intent = new Intent(ArtistesSearcheProtocolActivity.this, ResearcheByArtistByCityActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "S'il vous plait, entrez le nom d'artiste", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.choose_artist: {
                selectedItem = getSelectedArtist();

                if (!selectedItem.equals("") ) {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "Vous avez choisi : " + getSelectedArtist(), Toast.LENGTH_SHORT).show();
                    ArrayList<Artiste> tab = new ArrayList<Artiste>();
                    for (int i = 0; i < listeOfAllEvents.size(); i++) {
                        if (listeOfAllEvents.get(i).getName().equals(selectedItem)) {
                            tab.add(listeOfAllEvents.get(i));
                        }
                    }
                    Artiste.getDepotResultOfSearch().clear();
                    Artiste.setDepotResultOfSearch(tab);
                    Intent intent = new Intent(ArtistesSearcheProtocolActivity.this, ResearcheByArtistByCityActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "S'il vous plait, faites votre choix" + selectedItem, Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.choose_lieu: {
                selectedItem = "";
                selectedItem = getSelectedArtistCity();

                if (!selectedItem.equals("") ) {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "Vous avez choisi : " + selectedItem, Toast.LENGTH_SHORT).show();
                    ArrayList<Artiste> tab = new ArrayList<Artiste>();
                    for (int i = 0; i < listeOfAllEvents.size(); i++) {
                        if (listeOfAllEvents.get(i).getCity().equals(selectedItem)) {
                            tab.add(listeOfAllEvents.get(i));
                        }
                    }
                    Artiste.getDepotResultOfSearch().clear();
                    Artiste.setDepotResultOfSearch(tab);
                    Intent intent = new Intent(ArtistesSearcheProtocolActivity.this, ResearcheByArtistByCityActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ArtistesSearcheProtocolActivity.this, "S'il vous plait, faites votre choix" + getSelectedArtist(), Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }

    }


}