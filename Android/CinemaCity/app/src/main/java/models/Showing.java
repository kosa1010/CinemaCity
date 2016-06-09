package models;

import android.graphics.Movie;

import java.util.Date;
import java.util.List;

public class Showing {
    private Long id;

    private Date date;

    private String time;

    private Cinema cinema;

    private CinemaHall cinemahall;
    private Movie movie;

    List<Seat> allBusySeats;

    public Showing() {
        isActive = true;
    }

    private boolean isActive;
}
