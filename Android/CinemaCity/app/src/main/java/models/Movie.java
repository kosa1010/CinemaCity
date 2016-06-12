package models;

import java.util.Date;


public class Movie {
    private Long id;

    private String title;
    private String description;
    private Date publicationDate;

    public Movie(){

    }

    public Movie(Long id, String title, String description, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return title;
    }
}
