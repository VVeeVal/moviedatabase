package com.example.moviedatabaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabaseapp.Movie;
import com.example.moviedatabaseapp.MovieViewHolder;
import com.example.moviedatabaseapp.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.getTitle().setText(movie.getTitle());
        holder.getYear().setText(String.valueOf(movie.getYear()));
        holder.getGenre().setText(movie.getGenre());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
