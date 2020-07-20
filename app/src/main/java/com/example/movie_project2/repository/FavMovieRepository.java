package com.example.movie_project2.repository;

import android.app.Application;

import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.room.FavDao;
import com.example.movie_project2.room.FavRoomDatabase;

public class FavMovieRepository {
    public FavMovieRepository(Application application) {
        FavRoomDatabase favRoomDatabase = FavRoomDatabase.getDatabase(application);
        favDao = favRoomDatabase.favDao();

    }

    private FavDao favDao;
     public void remove(final FavouriteMovie movie){
         FavRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
             @Override
             public void run() {
                 favDao.delete(movie);
             }
         });

    }

}
