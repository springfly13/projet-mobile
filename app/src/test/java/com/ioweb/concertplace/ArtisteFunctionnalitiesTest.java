package com.ioweb.concertplace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Created by Fly on 30/09/2016.
 */
public class ArtisteFunctionnalitiesTest {
    @Test
    public void testCallResonse() throws Exception {

        String [] namesForCall = {"Adele"};
        ArrayList<Artiste> responseOfCall = new ArrayList<Artiste>();
        responseOfCall.clear();
        responseOfCall = Artiste.getListOfArtistes(namesForCall);
        for (int i=0; i<responseOfCall.size(); i++) {
            System.out.println(responseOfCall.get(i));
        }
        assertFalse(responseOfCall.isEmpty());

    }

}