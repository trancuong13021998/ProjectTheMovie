package com.example.projectmovie.detailmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.projectmovie.R;
import com.example.projectmovie.main.Movie;

public class DetailMovieActivity extends AppCompatActivity {
    TextView txtNameMovie, txtTime,txtDescription;
    ImageView imgItemMovie, imgAdvertisement;
    Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        init();
        LayDuLieu();
        ToolbarBack();
    }
    public void LayDuLieu() {
        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movie");
        txtNameMovie.setText(movie.getMoviename());
        txtTime.setText(movie.getMovieduration()+" phút");
        txtDescription.setText(movie.getDescription());
        Glide.with(getApplicationContext()).load(movie.getImgmovie()).into(imgItemMovie);
        Glide.with(getApplicationContext()).load(movie.getImgmovie()).into(imgAdvertisement);
    }
    public void ToolbarBack() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void init() {
        txtNameMovie = (TextView) findViewById(R.id.txt_activity_detail_movie_Name);
        txtTime = (TextView) findViewById(R.id.txt_activity_detail_movie_time);
        txtDescription = (TextView) findViewById(R.id.txt_activity_detail_movie_description);
        imgItemMovie = (ImageView)findViewById(R.id.img_activity_detail_movie_avatar);
        imgAdvertisement = (ImageView)findViewById(R.id.img_activity_detail_movie_advertisement);
        toolBar = (Toolbar)findViewById(R.id.tb_detail_movie);
    }

}
