package com.example.movie_project2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.repository.FavMovieRepository;

public class FavouriteMoviesViewModel extends AndroidViewModel {

    private FavMovieRepository favMovieRepository;
    public FavouriteMoviesViewModel(@NonNull Application application){
        super(application);
        favMovieRepository = new FavMovieRepository(application);
    }
   public void remove(FavouriteMovie favouriteMovie) {
        favMovieRepository.remove(favouriteMovie);
   }
}
