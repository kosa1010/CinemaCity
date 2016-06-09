package models;

/**
 * Created by root on 08.06.16.
 */

public class Booking {
    private Long id;

    private Showing showing;

    private Users user;

    private Seat seat;

    private Cinema cinema;

    public Booking() {
        isActive = true;
    }

    private boolean isActive;
}

