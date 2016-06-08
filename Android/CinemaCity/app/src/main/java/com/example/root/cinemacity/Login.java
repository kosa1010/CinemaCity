package com.example.root.cinemacity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import models.Cinema;
import models.CinemaHall;
import models.Seat;
import models.Users;

public class Login extends AppCompatActivity {

    Users user = new Users("kosa1010@o2.pl", "lubiepalcki");
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCinemaActiv();
            }
        });

    }

    public void addCinemaActiv() {
        new HttpRequestTask().execute();
        Toast.makeText(this, "Dodano kino", Toast.LENGTH_SHORT).show();
    }

    private class HttpRequestTask extends AsyncTask<Cinema, Void, Void> {
        List<Seat> listOfSeat = new ArrayList<Seat>();
        List<CinemaHall> listOfHall = new ArrayList<CinemaHall>();
        Seat s1 = new Seat();
        CinemaHall ch1 = new CinemaHall();

        @Override
        protected Void doInBackground(Cinema... params) {

            listOfSeat.add(s1);
            listOfHall.add(ch1);
            ch1.setSeats(listOfSeat);
            Cinema cinema = new Cinema("Mi", "mi", "mi", listOfHall);
            cinema.setList(listOfHall);

            String request = "http://192.168.1.137:8080/rest/cinema/add";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            HashSet<Object> params2 = new HashSet<>();

            params2.add(cinema.getName());
            params2.add(cinema.getCity());
            params2.add(cinema.getStreet());
            params2.add(String.valueOf(cinema.getNumber()));

            params2.add(listOfHall);


            restTemplate.postForObject(request, cinema, cinema.getClass(), params2);
            return null;
        }
    }
}
