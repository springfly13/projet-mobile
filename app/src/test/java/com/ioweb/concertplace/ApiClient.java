package com.ioweb.concertplace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Fly on 26/09/2016.
 */
public interface ApiClient {

 // @GET("users/{user}/repos")
// resultats d'appel de concert events
   @GET("artists/{artist}/events.json?api_version=2.0&app_id=My_concert_place")
   Call<List<ConcertEvent>> getEvents( @Path("artist") String artist);

// Call<List<Repo>> listRepos(@Path("user") String user);

    // http://api.bandsintown.com/artists/Skrillex/events.json?api_version=2.0&app_id=YOUR_APP_ID
}
