package com.ioweb.concertplace;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;

import android.widget.ListView;
import java.util.ArrayList;

public class ConcertsPerLieuActivity extends AppCompatActivity {    @Override

protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_concerts_per_lieu);

    ListView listView = (ListView)findViewById(R.id.listView3);

    /*ArrayList<Artiste> listNamesSort = Artiste.sortListByArtistesName();

    ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(

            this, android.R.layout.simple_list_item_1, listNamesSort);

    listView.setAdapter(adapter1);*/

}}