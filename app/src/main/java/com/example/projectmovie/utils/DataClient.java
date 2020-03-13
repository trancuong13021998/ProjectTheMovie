package com.example.projectmovie.utils;

import com.example.projectmovie.main.Movie;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {
    @GET("getmovies.php")
    Call<List<Movie>> GetMovies();
}
