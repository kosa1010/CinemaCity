package models;

import java.util.Date;


public class Movie {
    private Long id;

    private String title;
    private String description;
    private Date publicationDate;

    @Override
    public String toString() {
        return title;
    }
}
