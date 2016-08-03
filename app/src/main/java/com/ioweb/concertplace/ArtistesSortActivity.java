package com.ioweb.concertplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ArtistesSortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistes_sort);
        ListView listView = (ListView)findViewById(R.id.listView2);
        ArrayList<Artiste> listNamesSort = Artiste.sortListByArtistesName();
        ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_expandable_list_item_2, listNamesSort);
        listView.setAdapter(adapter1);
    }
}
