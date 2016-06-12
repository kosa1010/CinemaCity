package com.example.root.cinemacity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import models.Cinema;

public class CinemaActivity extends AppCompatActivity {
    private TextView textViewCinemas;
    private TextView textViewCinemas2;
    private List<Cinema> Cinemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCinemas2 = (TextView) findViewById(R.id.tvCinemas);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            dowloadAllCinemas();

        } else {
            textViewCinemas2 = (TextView) findViewById();
            textViewCinemas2.setText("Wlacz Wi-FI");
        }

    }

    public void downloadAllCinemas(View view) {
        dowloadAllCinemas();
    }

    private void dowloadAllCinemas() {
        //Odpalamy aplikacje webowa
        //ipconfig i sprawdzamy swoj lokalny adres/ip
        DownloadAllCinemaTask downloadAllCinemaTask = new DownloadAllCinemaTask();
        try {
            Cinemas = downloadAllCinemaTask.execute(RegisterActivity.URL + "/rest/cinema/all").get();
            textViewCinemas2 = (TextView) findViewById(R.id.tvCinemas);
            //textViewCinemas.setText("");

            for (Cinema m : Cinemas) {

                textViewCinemas2.append(m.getName() + "\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class DownloadAllCinemaTask extends AsyncTask<String, Void, List<Cinema>> {
        @Override
        protected List<Cinema> doInBackground(String... urls) {

            List<Cinema> CinemaList = null;
            try {
                final String url = RegisterActivity.URL + "/rest/cinema/all";
                RestTemplate restTemplate = new RestTemplate(true);

                Cinema[] list = restTemplate.getForObject(url, Cinema[].class);
                CinemaList = Arrays.asList(list);

                for (Cinema m : CinemaList) {
                    System.out.println(m.getName());
                }
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return CinemaList;
        }

        @Override
        protected void onPostExecute(List<Cinema> result) {

        }
    }
}
