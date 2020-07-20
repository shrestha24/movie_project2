package com.example.movie_project2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_project2.R;
import com.example.movie_project2.model.MovieReview;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    public static final String TAG = ReviewAdapter.class.getSimpleName();
    private Context context;
    private List<MovieReview.ResultsBean> mlist;
    final private ListItemClickListener1 mOnClickListener;

    public ReviewAdapter(Context context, List<MovieReview.ResultsBean> mlist, ListItemClickListener1 mOnClickListener) {
        this.context = context;
        this.mlist = mlist;
        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.reviewlayout, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        MovieReview.ResultsBean obj = mlist.get(position);
        holder.author.setText(obj.getAuthor());
        holder.review.setText(obj.getContent());


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public interface ListItemClickListener1 {
        void onListItemClick(int clickedIndex);
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView review, author;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            review = itemView.findViewById(R.id.userreview);
            author = itemView.findViewById(R.id.author);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }

}