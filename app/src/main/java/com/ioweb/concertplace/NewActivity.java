package com.ioweb.concertplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ArrayList<Artiste> listInformation = Artiste.getListOfArtistes();

            for (int i = 0; i < listInformation.size(); i++) {

                System.out.println(listInformation.get(i));
            }

    }
}
