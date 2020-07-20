package com.example.movie_project2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.movie_project2.R;
import com.example.movie_project2.adapter.MovieAdapter;
import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, MovieAdapter.ListItemClickListener {

    Spinner categories,page;
    Button search;
    RecyclerView recyclerView;
    String[] category={"popular","top_rated","upcoming"};
    Integer[] pages;
    List<Movie1.ResultsBean> listofMovies1;
    MovieAdapter movieAdapter;
    public  static int PAGE=1;
    public static   String CATEGORY="popular";
    public static final String TAG=MainActivity.class.getSimpleName();
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        populateDropdown();

        getMovie();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listofMovies1.clear();
                movieAdapter.notifyDataSetChanged();
                getMovie();

            }
        });
    }

    public static String getCATEGORY() {
        return CATEGORY;
    }

    public static int getPAGE() {
        return PAGE;
    }

    public void initialization(){
        categories=findViewById(R.id.category);
        page=findViewById(R.id.page);
        recyclerView=findViewById(R.id.recycler);
        search=findViewById(R.id.search);

        listofMovies1=new ArrayList<>();
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(calculateNoOfColumns(this), LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);

        movieAdapter=new MovieAdapter(MainActivity.this,listofMovies1,this::onListItemClick);
        recyclerView.setAdapter(movieAdapter);

        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);


    }
    public void getMovie() {
        mainActivityViewModel.getMovieResultsLiveData().observe(this, new Observer<Movie1>() {

            @Override
            public void onChanged(Movie1 movie12) {
                if (movie12 != null) {

                    List<Movie1.ResultsBean> listOfMovies;
                    listOfMovies = movie12.getResults();
                    listofMovies1.addAll(listOfMovies);
                    movieAdapter.notifyDataSetChanged();
                    int maxPage = movie12.getTotal_pages();

                    pages = new Integer[maxPage];
                    for (int i = 1; i <= maxPage; i++) {
                        pages[i - 1] = i;

                    }
                    ArrayAdapter<Integer> a2 = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_spinner_item, pages);
                    a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    page.setAdapter(a2);

                }
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

    void populateDropdown(){

        categories.setOnItemSelectedListener(this);
        page.setOnItemSelectedListener(this);
        ArrayAdapter a1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);


        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        categories.setAdapter(a1);



    }


    public void bt_fav(View view) {
        Intent intent= new Intent(MainActivity.this,Favourites.class);
        startActivity(intent);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.category:
                CATEGORY = category[i];
                break;

            case R.id.page:
                PAGE = pages[i];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onListItemClick(int clickedIndex) {
        Intent intent=new Intent(MainActivity.this,DetailedActivity.class);

        intent.putExtra("DATA",listofMovies1.get(clickedIndex));


        startActivity(intent);

    }
}