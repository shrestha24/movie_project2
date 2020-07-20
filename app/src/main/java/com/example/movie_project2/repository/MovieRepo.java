package com.example.movie_project2.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_project2.model.Movie1;
import com.example.movie_project2.networking.ApiInterface;
import com.example.movie_project2.networking.RetrofitRequests;
import com.example.movie_project2.utils.NetworkChecker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {
    private static final String TAG = MovieRepo.class.getSimpleName();
    private ApiInterface apiInterface;


    public MovieRepo() {
        apiInterface = RetrofitRequests.getRetrofitInstance().create(ApiInterface.class);
    }
    public LiveData<Movie1> getMovieResults(Context context, String category, String apikey, String language, int page){
        final MutableLiveData<Movie1> data =new MutableLiveData<>();
        if (NetworkChecker.connected(context)!=false){

            apiInterface.getlistOfMovies(category,apikey,language,page)
                    .enqueue(new Callback<Movie1>() {
                        @Override
                        public void onResponse(Call<Movie1> call, Response<Movie1> response) {
                            data.setValue(response.body());
//                        Log.d(TAG,"TOTAL RESULTS "+response.body().getTotal_results());
                        }

                        @Override
                        public void onFailure(Call<Movie1> call, Throwable t) {
                            data.setValue(null);
                            Log.e(TAG,"FAILED" +t.getMessage());

                        }
                    });





            return data;
        }else {
            Toast.makeText(context, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
        }
        data.setValue(null);
        return data;
    }


}
