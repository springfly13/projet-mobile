package com.ioweb.concertplace;

import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Bundle bundle;
    String maValeur;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //maValeur = savedInstanceState.getString("key");
        //this.bundle = savedInstanceState;
        listView = (ListView)findViewById(R.id.listView1);
    }

    /*@Override
    protected void onListItemClick();
    super.onListeItemClick (l, v, position, id);
    Intent intent = new Intent(this, NetworkInfo.DetailedState);*/



}
