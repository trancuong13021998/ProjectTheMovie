package com.example.projectmovie.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectmovie.R;
import com.example.projectmovie.detailmovie.DetailMovieActivity;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemHolder> {
    Context context;
    ArrayList<Movie> movieArrayList;
    OnClickMovieInterface onClickMove;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Movie movie =movieArrayList.get(position);
        holder.txtTime.setText(movie.getMovieduration()+" phút");
        holder.txtMovieName.setText(movie.getMoviename());
        Glide.with(context).load(movie.getImgmovie()).into(holder.imgMovie);
        holder.imgMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra("movie",movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }
    public class ItemHolder extends RecyclerView.ViewHolder{
        TextView txtMovieName, txtTime;
        ImageView imgMovie;
        Movie movie;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txtMovieName = (TextView)itemView.findViewById(R.id.txt_activity_detail_movie_Name);
            txtTime =(TextView)itemView.findViewById(R.id.txt_activity_detail_movie_time);
            imgMovie = (ImageView) itemView.findViewById(R.id.img_activity_detail_movie_avatar);


        }
    }
}
