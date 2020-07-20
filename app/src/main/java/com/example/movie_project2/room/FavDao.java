package com.example.movie_project2.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movie_project2.model.FavouriteMovie;

import java.util.List;
@Dao
public interface FavDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FavouriteMovie word);

    @Delete
    void delete(FavouriteMovie word);

    @Query("DELETE FROM movietable")
    void deleteAll();

    @Query("SELECT * from movietable ORDER BY movie ASC")
    LiveData<List<FavouriteMovie>> getAlphabetizedWords();
}
