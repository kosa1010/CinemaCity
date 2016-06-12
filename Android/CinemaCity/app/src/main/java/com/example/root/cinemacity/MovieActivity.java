package com.example.root.cinemacity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import get_data.GetMoviesFromRest;
import models.Movie;

public class MovieActivity extends AppCompatActivity {

    private ListView lvMovie;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        lvMovie = (ListView) findViewById(R.id.lvMovie);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            loadMoviesToView();

        }
    }

    private void loadMoviesToView() {
        GetMoviesFromRest movieFromRest = new GetMoviesFromRest();
        try {
            movieList = movieFromRest.execute(RegisterActivity.URL + "/rest/movie/all").get();
            String[] movieListStr = new String[movieList.size()];
            for (int i = 0; i < movieList.size(); i++) {
                movieListStr[i] = movieList.get(i).toString();
                System.out.println(movieListStr[i]);
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1, movieListStr);
            lvMovie.setAdapter(arrayAdapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
//        } catch (Exception e) {
//            Toast.makeText(this, "Nie udało się", Toast.LENGTH_LONG).show();
        }
    }
}
