package models;

/**
 * Created by root on 08.06.16.
 */

public class Seat {

    private Long id;

    private int numberOfSeat;

    public Seat() {
    }

    public Seat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }
}