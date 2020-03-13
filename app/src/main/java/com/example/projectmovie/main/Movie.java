package com.example.projectmovie.main;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("moviename")
    @Expose
    private String moviename;
    @SerializedName("movieduration")
    @Expose
    private String movieduration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imgmovie")
    @Expose
    private String imgmovie;

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

    public String getMovieduration() {
        return movieduration;
    }

    public void setMovieduration(String movieduration) {
        this.movieduration = movieduration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgmovie() {
        return imgmovie;
    }

    public void setImgmovie(String imgmovie) {
        this.imgmovie = imgmovie;
    }

}