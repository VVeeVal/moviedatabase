package com.example.moviedatabaseapp;
//just a class with getters
public class Movie {
    String title;
    Integer year;
    String genre;
    String posterResource;

    public Movie(String title, Integer year, String genre, String posterResource){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResource = posterResource;
    }

    public String getTitle() {
        try {
            return title;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public int getYear() {
        try {
            return year;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getGenre() {
        try {
            return genre;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getPosterResource() {
        try {
            return posterResource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
