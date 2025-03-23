package com.example.moviedatabaseapp;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    public static List<Movie> loadMovies(Context context) {
        List<Movie> movieList = new ArrayList<>();
        try {
            // Using input stream to read the contents of the json
            InputStream is = context.getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            //Looping over the jsonarray creating a movie class for each movie
            //with error handling for when the fields are empty or named null
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    //handling the title
                    String title = obj.optString("title", "Unknown Title");
                    if(title == "" || title == "null" || title == "Unknown Title"){
                        continue;
                    }
                    //handling the year and making sure its within reasonable range
                    int year = obj.optInt("year", 0);
                    if(year <1900 || year > 2030){
                        year = 0;
                    }
                    //handling the genre
                    String genre = obj.optString("genre", "Unknown Genre");
                    if (genre == "null"){
                        genre = "Unknown genre";
                    }
                    String posterResource = obj.optString("posterResource", "default.jpg");

                    Movie movie = new Movie(title, year, genre, posterResource);
                    //adding the created movie to the movieList
                    movieList.add(movie);
                }catch (Exception e){
                    System.out.println(e.getMessage() + "Index: "+ i);
                }

            }
            //catching errors with the json and printing the error and stack for inspection
        } catch (IOException | JSONException e) {
            System.out.println("Error loading JSON " +e.getMessage());
            e.printStackTrace();
        }
        return movieList;
    }
}
