package com.ioweb.concertplace;

import org.junit.Test;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void testRetrofit() throws Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.bandsintown.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiClient service = retrofit.create(ApiClient.class);
        Call<List<ConcertEvent>> events =   service.getEvents("Zaz");
        List<ConcertEvent> concertEventsList = events.execute().body();
        for (ConcertEvent i : concertEventsList){
            System.out.println(i.getTitle());
        }

        return ;
    }
}