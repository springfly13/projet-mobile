package com.ioweb.concertplace;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ListView listView = (ListView)findViewById(R.id.listView1);
        /*ArrayList<Artiste> listNames = Artiste.getListOfArtistes();
        ArrayAdapter adapter = new ArrayAdapter<Artiste>(
                    this, android.R.layout.simple_expandable_list_item_1, listNames);
        listView.setAdapter(adapter);*/
        ArrayList<Artiste> listNamesSort = Artiste.sortListByArtistesName();
        ArrayAdapter adapter1 = new ArrayAdapter<Artiste>(
                this, android.R.layout.simple_expandable_list_item_1, listNamesSort);
        listView.setAdapter(adapter1);

    }
}
