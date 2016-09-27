package com.ioweb.concertplace;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fly on 26/09/2016.
 */
public class ConcertResearcheService {


        public List<ConcertEventOfRequest> researchOfConcerts(String nameOfArtist) throws Exception  {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.bandsintown.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiClientRequest service = retrofit.create(ApiClientRequest.class);
            Call<List<ConcertEventOfRequest>> events = service.getEvents(nameOfArtist);
            List<ConcertEventOfRequest> concertEventsList = events.execute().body();
            /*for (ConcertEventOfRequest i : concertEventsList){
                System.out.println(i.getVenue().getCountry());
            }*/

            return concertEventsList ;
        }

}
