package com.ioweb.concertplace;

import android.content.Intent;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Bundle bundle;
    String maValeur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maValeur = savedInstanceState.getString("key");
        this.bundle = savedInstanceState;
    }

    /*@Override
    protected void onListItemClick();
    super.onListeItemClick (l, v, position, id);
    Intent intent = new Intent(this, NetworkInfo.DetailedState);*/



}
