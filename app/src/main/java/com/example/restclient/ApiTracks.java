package com.example.restclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiTracks {



     @GET("tracks")
    Call<List<Tracks>> mistracks();


    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://147.83.7.203:8080/dsaApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    @GET("tracks/{id}")
    Call<Tracks> track( @Path("id") String id);

    @PUT("traks")
    Call<Void> editTrack (@Body Tracks tracks);


    @DELETE("traks/{id}")
    Call<Void> deleteTrack (@Path("id") String id);
}










