package com.example.movie_project2.networking;

import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.model.MovieReview;
import com.example.movie_project2.model.YoutubeTrailer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/3/movie/{category}")
    Call<Movie1> getlistOfMovies(
            @Path("category") String category,
            @Query("api_key") String APIKEY,
            @Query("language") String language,
            @Query("page") int page
    );


    @GET("/3/movie/{movieid}/videos")
    Call<YoutubeTrailer> getTrailerCall(
            @Path("movieid") int movieid,
            @Query("api_key") String APIKEY,
            @Query("language") String language


    );

    @GET("/3/movie/{movieid}/reviews")
    Call<MovieReview> getReviewCall(
            @Path("movieid") int movieid,
            @Query("api_key") String APIKEY,
            @Query("language") String language,
            @Query("page") int page

    );



}
