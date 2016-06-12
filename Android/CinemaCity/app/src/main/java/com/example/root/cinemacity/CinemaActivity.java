package com.example.root.cinemacity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import java.util.concurrent.ExecutionException;
import get_data.GetCinemasFromRest;
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
        textViewCinemas = (TextView) findViewById(R.id.tvCinemas);
        GetCinemasFromRest downloadAllCinemaFromRest = new GetCinemasFromRest();
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
}