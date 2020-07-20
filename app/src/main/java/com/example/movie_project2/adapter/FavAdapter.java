package com.example.movie_project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_project2.R;
import com.example.movie_project2.model.FavouriteMovie;

import java.util.ArrayList;
import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavouriteViewHolder> {



    private final LayoutInflater mInflater;
    private ListItemClickListener mOnClickListener;
    private List<FavouriteMovie> favouriteModels; // Cached copy of words
    Context context;


    public FavAdapter(Context context,ListItemClickListener mOnClickListener) {
        favouriteModels=new ArrayList<>();
        this.context=context;
        mInflater=LayoutInflater.from(context);
        this.mOnClickListener=mOnClickListener;



    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedIndex);
    }
    public void clearView(){
        favouriteModels.clear();
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.itemlist, parent, false);
        return new FavouriteViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        if (favouriteModels.size()!=0) {
            FavouriteMovie current = favouriteModels.get(position);
            Glide.with(context).load(current.getUrl()).into(holder.imageView);
        } else {
            // Covers the case of data not being ready yet.
            Toast.makeText(context, "No Favourite Movie Saved", Toast.LENGTH_SHORT).show();
        }


    }
    public void setMovie(List<FavouriteMovie> words){
        favouriteModels.addAll(words);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (favouriteModels != null)
            return favouriteModels.size();
        else return 0;
    }

    class FavouriteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        private FavouriteViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.postImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }
}
