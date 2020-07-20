package com.example.movie_project2.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequests {
    public static final String BASE_URL="https://api.themoviedb.org";
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit= new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
