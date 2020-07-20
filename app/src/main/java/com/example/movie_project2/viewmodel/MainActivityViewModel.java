package com.example.movie_project2.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie_project2.R;
import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.repository.MovieRepo;
import com.example.movie_project2.view.MainActivity;

public class MainActivityViewModel extends AndroidViewModel {
    public static String LANGUAGE="en-us";


    private   static  String apikey;
    private MovieRepo movieRepo;
    private LiveData<Movie1> movieResultsLiveData;
    private Context context;

    public LiveData<Movie1> getMovieResultsLiveData() {
        this.movieResultsLiveData = movieRepo.getMovieResults(context, MainActivity.getCATEGORY(),apikey,LANGUAGE,MainActivity.getPAGE());
        return movieResultsLiveData;
    }

    public MainActivityViewModel(@NonNull Application application) {

        super(application);
        movieRepo = new MovieRepo();
        apikey = application.getResources().getString(R.string.apikey);
        this.context = application.getApplicationContext();
        this.movieResultsLiveData = movieRepo.getMovieResults(context, MainActivity.getCATEGORY(),apikey,LANGUAGE,MainActivity.getPAGE());

    }


}
