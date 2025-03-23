package com.example.moviedatabaseapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;
//Class with getters
public class MovieViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    TextView title;
    TextView year;
    TextView genre;
    ImageView posterResource;


    public MovieViewHolder(View itemView) {
        super(itemView);
        title =  itemView.findViewById(R.id.title);
        year = itemView.findViewById(R.id.year);
        genre = itemView.findViewById(R.id.genre);
        posterResource = itemView.findViewById(R.id.posterResource);

    }
    public TextView getTitle() {
        return title;
    }
    public TextView getYear() {
        return year;
    }
    public TextView getGenre() {
        return genre;
    }
    public ImageView getPosterResource() {
        return posterResource;
    }

}