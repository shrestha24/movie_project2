package com.example.movie_project2.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.room.FavDao;
import com.example.movie_project2.room.FavRoomDatabase;

import java.util.List;

public class FavRepo {
    private FavDao favDao;
    private LiveData<List<FavouriteMovie>> mAllMovie;

    public FavRepo(Application application) {
        FavRoomDatabase db = FavRoomDatabase.getDatabase(application);
        favDao = db.favDao();
        mAllMovie = favDao.getAlphabetizedWords();
    }
    public LiveData<List<FavouriteMovie>> getAllMovie() {
        return mAllMovie;
    }

    public void insert(final FavouriteMovie movie) {
        FavRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                favDao.insert(movie);
            }
        });

    }
}
