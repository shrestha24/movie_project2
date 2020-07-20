package com.example.movie_project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_project2.R;
import com.example.movie_project2.model.Movie1;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    public static final String TAG=MovieAdapter.class.getSimpleName();
    private Context context;
    private List<Movie1.ResultsBean> mlist;
    final private ListItemClickListener mOnClickListener;

    public MovieAdapter(Context context, List<Movie1.ResultsBean> mlist, ListItemClickListener mOnClickListener) {
        this.context = context;
        this.mlist = mlist;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.itemlist,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie1.ResultsBean obj=mlist.get(position);
        String url="http://image.tmdb.org/t/p/w500/"+obj.getPoster_path();
        Glide.with(context).load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public interface  ListItemClickListener {
        void onListItemClick(int clickedIndex);
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.postImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }




}
