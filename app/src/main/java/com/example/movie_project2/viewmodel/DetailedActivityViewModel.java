package com.example.movie_project2.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie_project2.R;
import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.model.MovieReview;
import com.example.movie_project2.model.YoutubeTrailer;
import com.example.movie_project2.repository.MovieDetailsRepo;
import com.example.movie_project2.view.DetailedActivity;

public class DetailedActivityViewModel extends AndroidViewModel {

    public static String LANGUAGE="en-us";


    private   static  String apikey;
    private static int page=1;
    private MovieDetailsRepo movieDetailsRepo;
    private LiveData<MovieReview> movieReviewLiveData;
    private LiveData<YoutubeTrailer> trailerLiveData;
    private Context context;


    public DetailedActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
        apikey=application.getResources().getString(R.string.apikey);
        movieDetailsRepo=new MovieDetailsRepo(application);
        this.movieReviewLiveData=movieDetailsRepo.getMovieReview(context, DetailedActivity.getMovieID(),apikey,LANGUAGE,page);
        this.trailerLiveData=movieDetailsRepo.getMovieTrailer(context,DetailedActivity.getMovieID(),apikey,LANGUAGE);

    }

    public LiveData<MovieReview> getMovieReviewLiveData() {

        this.movieReviewLiveData=movieDetailsRepo.getMovieReview(context, DetailedActivity.getMovieID(),apikey,LANGUAGE,page);
        return movieReviewLiveData;
    }

    public LiveData<YoutubeTrailer> getTrailerLiveData() {
        this.trailerLiveData=movieDetailsRepo.getMovieTrailer(context,DetailedActivity.getMovieID(),apikey,LANGUAGE);

        return trailerLiveData;
    }
    public void insert(FavouriteMovie favouriteModel){
        movieDetailsRepo.insert(favouriteModel);
        Log.e(DetailedActivityViewModel.class.getSimpleName(),"INSERTION SUCCESS");
    }
}
