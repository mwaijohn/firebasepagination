package com.example.firebasepaginationdemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.firebase.ui.firestore.paging.LoadingState;

public class NewsAdapter extends FirestorePagingAdapter<NewsModel, NewsAdapter.NewsHolder> {
    public NewsAdapter(@NonNull FirestorePagingOptions<NewsModel> options) {
        super(options);
    }

    @Override
    protected void onLoadingStateChanged(@NonNull LoadingState state) {
        super.onLoadingStateChanged(state);
        switch (state){
            case LOADED:
                Log.d("items","Items loaded"+getItemCount());
            case FINISHED:
                Log.d("items","all items loaded" +getItemCount());
            case LOADING_MORE:
                Log.d("items","Loading more");
            case ERROR:
                Log.d("items","An error occurred");
            case LOADING_INITIAL:
                Log.d("items","Initial loading,first time load");
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsHolder holder, int position, @NonNull NewsModel model) {
        holder.headline.setText(model.getHeadline());
        holder.description.setText(model.getDescription());
    }
    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,
                parent, false);
        return new NewsHolder(v);
    }
    static class NewsHolder extends RecyclerView.ViewHolder {
        TextView headline;
        TextView description;
        public NewsHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            headline = itemView.findViewById(R.id.headline);
        }
    }
}
