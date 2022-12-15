package com.jarod.bean;

public class Movie {
    String id,moviename,moviedetail;


    public Movie(String id, String moviename, String moviedetail) {
        this.id = id;
        this.moviename = moviename;
        this.moviedetail = moviedetail;
    }

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMoviedetail() {
        return moviedetail;
    }

    public void setMoviedetail(String moviedetail) {
        this.moviedetail = moviedetail;
    }
}
