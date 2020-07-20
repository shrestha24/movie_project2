package com.example.movie_project2.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_project2.model.FavouriteMovie;
import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.model.MovieReview;
import com.example.movie_project2.model.YoutubeTrailer;
import com.example.movie_project2.networking.ApiInterface;
import com.example.movie_project2.networking.RetrofitRequests;
import com.example.movie_project2.room.FavDao;
import com.example.movie_project2.room.FavRoomDatabase;
import com.example.movie_project2.utils.NetworkChecker;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsRepo {
    private static final String TAG = MovieRepo.class.getSimpleName();
    private ApiInterface apiInterface;
    private FavDao favDao;
    private LiveData<List<FavouriteMovie>> mAllMovie;


    public MovieDetailsRepo(Application application) {
        apiInterface = RetrofitRequests.getRetrofitInstance().create(ApiInterface.class);
        FavRoomDatabase db = FavRoomDatabase.getDatabase(application);
        favDao = db.favDao();
        mAllMovie = favDao.getAlphabetizedWords();
    }

    public LiveData<MovieReview> getMovieReview(Context context, int movieId, String apikey, String language, int page){
        final MutableLiveData<MovieReview> data =new MutableLiveData<>();
        if (NetworkChecker.connected(context)!=false){
            apiInterface.getReviewCall(movieId,apikey,language,page)
                    .enqueue(new Callback<MovieReview>() {
                        @Override
                        public void onResponse(Call<MovieReview> call, Response<MovieReview> response) {
                            data.setValue(response.body());
                            Log.d(TAG,"SUCCESS"+response.body().getTotal_results());
                        }

                        @Override
                        public void onFailure(Call<MovieReview> call, Throwable t) {
                            data.setValue(null);
                            Log.e(TAG,"FAILED" +t.getMessage());

                        }
                    });

        }else{
            Toast.makeText(context, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
            data.setValue(null);
        }
        return data;
    }
    public LiveData<YoutubeTrailer> getMovieTrailer(Context context, int movieId, String apikey, String language){
        final MutableLiveData<YoutubeTrailer> data1=new MutableLiveData<>();
        if (NetworkChecker.connected(context) != false) {
            apiInterface.getTrailerCall(movieId,apikey,language).enqueue(new Callback<YoutubeTrailer>() {
                @Override
                public void onResponse(Call<YoutubeTrailer> call, Response<YoutubeTrailer> response) {
                    data1.setValue(response.body());
                    Log.d(TAG,"SUCCESS"+response.body().getResults().size());
                }

                @Override
                public void onFailure(Call<YoutubeTrailer> call, Throwable t) {
                    data1.setValue(null);
                    Log.e(TAG,"FAILED" +t.getMessage());

                }
            });


        }else {
            Toast.makeText(context, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
            data1.setValue(null);
        }
        return data1;
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
