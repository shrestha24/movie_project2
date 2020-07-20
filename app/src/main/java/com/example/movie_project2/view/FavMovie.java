package com.example.movie_project2.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.movie_project2.R;
import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.utils.NetworkChecker;
import com.example.movie_project2.viewmodel.FavouriteMoviesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavMovie extends AppCompatActivity {
    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.ratings)
    TextView rating;
    @BindView(R.id.release_date)
    TextView releaseDate;

    FavouriteMovie favouriteMovie;
    String ytkey;
    private FavouriteMoviesViewModel favouriteMoviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movie);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        favouriteMovie =intent.getParcelableExtra("OBJECT");
        favouriteMoviesViewModel = new ViewModelProvider(this).get(FavouriteMoviesViewModel.class);
        populate();
    }

    private void populate() {
        Glide.with(this).load(favouriteMovie.getUrl()).into(thumbnail);
        title.setText(favouriteMovie.getMoviename());
        description.setText(favouriteMovie.getDescription());
        rating.setText(Float.toString(favouriteMovie.getRating()));
        releaseDate.setText(favouriteMovie.getRdate());
        ytkey = favouriteMovie.getYtid();
    }

       public void bt_playyt(View view) {
        if (NetworkChecker.connected(this)!=false){
            String url = "https://www.youtube.com/watch?v=" + ytkey;
            Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            Intent chooser = Intent.createChooser(yt_play, "Open With");
            chooser.putExtra("VIDEO ID", ytkey);
            startActivity(chooser);

        }
        else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void remove(View view) {
        favouriteMoviesViewModel.remove(favouriteMovie);
        Toast.makeText(this, "Removed From Favourite", Toast.LENGTH_SHORT).show();
        finish();
    }
}

