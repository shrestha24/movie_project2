package com.example.movie_project2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.repository.FavRepo;

import java.util.List;

public class FavouriteViewModel extends AndroidViewModel {
    private FavRepo favRepo;
    private LiveData<List<FavouriteMovie>> mallMovies;
    public FavouriteViewModel(@NonNull Application application) {
        super(application);
        favRepo=new FavRepo(application);
        mallMovies=favRepo.getAllMovie();
    }
    public LiveData<List<FavouriteMovie>> getAllMovies(){
        return mallMovies;
    }
    public void insert(FavouriteMovie favouriteModel){
        favRepo.insert(favouriteModel);
    }
}
