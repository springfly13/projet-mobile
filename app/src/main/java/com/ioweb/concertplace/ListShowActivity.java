package com.ioweb.concertplace;

import java.util.ArrayList;

/**
 * Created by Fly on 03/08/2016.
 */
public class ListShowActivity {
    ArrayList<Artiste> listInformation = Artiste.getListOfArtistes();

    public ListShowActivity() {
        for (int i = 0; i < listInformation.size(); i++) {

            System.out.println(listInformation.get(i));
        }
    }
}