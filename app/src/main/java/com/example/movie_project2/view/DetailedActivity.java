package com.example.movie_project2.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_project2.R;
import com.example.movie_project2.adapter.ReviewAdapter;
import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.model.MovieReview;
import com.example.movie_project2.model.YoutubeTrailer;
import com.example.movie_project2.viewmodel.DetailedActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedActivity extends AppCompatActivity implements ReviewAdapter.ListItemClickListener1{


    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.bt_trailer)
    Button yt;
    @BindView(R.id.bt_fav)
    Button fav;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.release_date)
    TextView releaseDate;
    @BindView(R.id.ratings)
    TextView rating;
    @BindView(R.id.reviewlist)
    RecyclerView recyclerView;


    Movie1.ResultsBean object;
    private static int movieID;

    ReviewAdapter adapter;
    List<MovieReview.ResultsBean> listofReview;
    List<YoutubeTrailer.ResultsBean> listofTrailer;
    DetailedActivityViewModel detailActivityViewModel;
    private static String ytid;
    int size;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    String url;

    public static int getMovieID() {
        return movieID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        object = intent.getParcelableExtra("DATA");
        movieID=object.getId();
        Log.e(DetailedActivity.class.getSimpleName(),"movie id: "+movieID);
        Toast.makeText(this, "movie id: "+movieID, Toast.LENGTH_SHORT).show();
        initialization();
        getData();
        populate();
    }

    private void getData() {

        detailActivityViewModel.getMovieReviewLiveData().observe(this, new Observer<MovieReview>() {
            @Override
            public void onChanged(MovieReview movieReview) {
                if(movieReview!=null){
                    List<MovieReview.ResultsBean> listofreview1 = movieReview.getResults();
                    listofReview.addAll(listofreview1);
                    adapter.notifyDataSetChanged();
                }

            }
        });

        detailActivityViewModel.getTrailerLiveData().observe(this, new Observer<YoutubeTrailer>() {
            @Override
            public void onChanged(YoutubeTrailer trailer) {
                if (trailer != null) {
                    List<YoutubeTrailer.ResultsBean> listoftrailer1=trailer.getResults();
                    listofTrailer.addAll(listoftrailer1);
                    ytid=listoftrailer1.get(0).getKey();

                    Log.e(DetailedActivity.class.getSimpleName(),listoftrailer1.get(0).getKey());


                }

            }
        });


    }

    private void initialization() {

        listofReview=new ArrayList<>();
        listofTrailer=new ArrayList<>();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter=new ReviewAdapter(DetailedActivity.this,listofReview,this);
        recyclerView.setAdapter(adapter);

        detailActivityViewModel= ViewModelProviders.of(this).get(DetailedActivityViewModel.class);
    }

    public void populate(){
        url = "http://image.tmdb.org/t/p/w500/" + object.getPoster_path();
        Glide.with(this).load(url).into(thumbnail);
        title.setText(object.getOriginal_title());
        description.setText(object.getOverview());
        releaseDate.setText(object.getRelease_date());
        rating.setText(Float.toString(object.getVote_average()));
        size=listofTrailer.size();
        if(size!=0) {
            YoutubeTrailer.ResultsBean obj = listofTrailer.get(size - 1);
            ytid = obj.getId();
        }
    }

    @Override
    public void onListItemClick(int clickedIndex) {
        Toast.makeText(this, "Clicked on", Toast.LENGTH_SHORT).show();
    }


    public void add_fav(View view) {
        FavouriteMovie obj1 =new FavouriteMovie();
        obj1.setMoviename(object.getTitle());
        obj1.setDescription(object.getOverview());
        obj1.setRating(object.getVote_average());
        //obj1.rdate(object.getRelease_date());
        obj1.setRdate(object.getRelease_date());
        obj1.setUrl(url);
        obj1.setYtid(ytid);
        detailActivityViewModel.insert(obj1);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    public void bt_youtube(View view) {
        String url = "https://www.youtube.com/watch?v=" + ytid;
        Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent chooser = Intent.createChooser(yt_play, "Open With");
        chooser.putExtra("VIDEO ID", ytid);
        startActivity(chooser);
    }
}