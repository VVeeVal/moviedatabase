package com.example.moviedatabaseapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabaseapp.Movie;
import com.example.moviedatabaseapp.MovieAdapter;
import com.example.moviedatabaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    JsonLoader jsonLoader;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize movie list BEFORE setting adapter
        movieList = new ArrayList<>();
        jsonLoader = new JsonLoader();
        Context context = this;
        movieList = JsonLoader.loadMovies(context);

        // Initialize adapter and attach it to RecyclerView
        adapter = new MovieAdapter(movieList, this);
        recyclerView.setAdapter(adapter); // 🚀 This must be done before layout is drawn

        // Debugging check
        if (adapter == null) {
            Log.e("MainActivity", "Adapter is null!");
        }
        if (recyclerView.getAdapter() == null) {
            Log.e("MainActivity", "RecyclerView has no adapter!");
        }
    }
}
