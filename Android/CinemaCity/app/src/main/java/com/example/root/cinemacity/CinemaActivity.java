package com.example.root.cinemacity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.root.cinemacity.R;
import com.example.root.cinemacity.RegisterActivity;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import models.Cinema;

public class CinemaActivity extends AppCompatActivity {

    private TextView textViewCinemas;
    private List<Cinema> cinemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            loadCinemasToView();

        } else {
            textViewCinemas = (TextView) findViewById(R.id.tvCinemas);
            textViewCinemas.setText("Wlacz Wi-FI");
        }
    }

    private void loadCinemasToView() {
        //Odpalamy aplikacje webowa
        //ipconfig i sprawdzamy swoj lokalny adres/ip
        textViewCinemas = (TextView) findViewById(R.id.tvCinemas);
        DownloadAllCinemaFromRest downloadAllCinemaFromRest = new DownloadAllCinemaFromRest();
        try {
            cinemas = downloadAllCinemaFromRest.execute(RegisterActivity.URL + "/rest/movie/all").get();
            textViewCinemas.setText("");
            for (Cinema c : cinemas) {
                System.out.println(c.getName());
                textViewCinemas.append(c.getName() + "\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class DownloadAllCinemaFromRest extends AsyncTask<String, Void, List<Cinema>> {
        @Override
        protected List<Cinema> doInBackground(String... urls) {

            List<Cinema> cinemasList = null;
            try {
                final String url = RegisterActivity.URL + "/rest/cinema/all";
                RestTemplate restTemplate = new RestTemplate(true);

                Cinema[] list = restTemplate.getForObject(url, Cinema[].class);
                cinemasList = Arrays.asList(list);

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return cinemasList;
        }

        @Override
        protected void onPostExecute(List<Cinema> result) {

        }
    }
}