package com.example.movie_project2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.movie_project2.R;
import com.example.movie_project2.adapter.FavAdapter;
import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.viewmodel.FavouriteViewModel;

import java.util.ArrayList;
import java.util.List;

public class Favourites extends AppCompatActivity implements FavAdapter.ListItemClickListener{
    private FavouriteViewModel favouriteViewModel;
    List<FavouriteMovie> favouriteMoviesList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        favouriteMoviesList1 = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final FavAdapter adapter = new FavAdapter(this,this::onListItemClick);
        recyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(calculateNoOfColumns(this),LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        favouriteViewModel=new ViewModelProvider(this).get(FavouriteViewModel.class);

        favouriteViewModel.getAllMovies().observe(this, new Observer<List<FavouriteMovie>>() {
            @Override
            public void onChanged(List<FavouriteMovie> favouriteModels) {
                adapter.clearView();
                adapter.setMovie(favouriteModels);
                favouriteMoviesList1.addAll(favouriteModels);
                Toast.makeText(Favourites.this, "DATA OBJECTS:"+favouriteModels.size(), Toast.LENGTH_SHORT).show();


            }
        });

    }
    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int scalingFactor = 200;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        if(noOfColumns < 2)
            noOfColumns = 2;
        return noOfColumns;
    }

    @Override
    public void onListItemClick(int clickedIndex) {
        Intent intent = new Intent(Favourites.this,FavMovie.class);
        intent.putExtra("OBJECT",favouriteMoviesList1.get(clickedIndex));
        startActivity(intent);


    }
}