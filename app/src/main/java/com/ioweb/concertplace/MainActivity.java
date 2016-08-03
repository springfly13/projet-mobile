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
        //maValeur = savedInstanceState.getString("key");
        //this.bundle = savedInstanceState;
        Button buttonAllArtistes = (Button)findViewById(R.id.button5);
        buttonAllArtistes.setOnClickListener((View.OnClickListener) this);
        //listView = (ListView)findViewById(R.id.listView1);
    }
    private void showListOfArtistes (){

        System.out.println("List of Artistes ");
        /*for (int i=0; i<list.size(); i++) {
            Artiste artisteInfo = list.get(i);
            System.out.println(artisteInfo);
        }*/
    }

    /*@Override
    public void onClick(View v) {
        showListOfArtistes();

    }*/

    public void onClickOnButton(View view) {

       // System.out.println("List of Artistes ");
        //showListOfArtistes();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

        //showListOfArtistes();
    }

    /*@Override
    protected void onListItemClick();
    super.onListeItemClick (l, v, position, id);
    Intent intent = new Intent(this, NetworkInfo.DetailedState);*/



}
