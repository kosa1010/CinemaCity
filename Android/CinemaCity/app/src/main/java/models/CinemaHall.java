package models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 08.06.16.
 */
public class CinemaHall {

    private Long id;

    private String name;

    private int numberOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    List<Seat> seats;

    public CinemaHall() {
        seats = new LinkedList<Seat>();
    }
}
