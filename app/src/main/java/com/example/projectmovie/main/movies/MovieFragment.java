package com.example.projectmovie.main.movies;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmovie.R;
import com.example.projectmovie.main.Movie;
import com.example.projectmovie.main.MovieAdapter;
import com.example.projectmovie.utils.APIUtils;
import com.example.projectmovie.utils.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    MovieAdapter movieAdapter;
    ArrayList<Movie> movieArrayList;
    RecyclerView recyclerView;
    public MovieFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcl_fragment_movie);
        movieArrayList = new ArrayList<>();
        DataClient dataClient = APIUtils.GetData();
        Call<List<Movie>> call = dataClient.GetMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieArrayList = new ArrayList<>(response.body());
                movieAdapter = new MovieAdapter(getActivity(),movieArrayList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                recyclerView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });

        return view;
    }


}
