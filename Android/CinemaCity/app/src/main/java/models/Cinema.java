package models;

import java.util.List;

/**
 * Created by root on 08.06.16.
 */
public class Cinema {

    private Long id;

    public Cinema(String name, String city, String street, int number, List<CinemaHall> list) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.number = number;
        this.list = list;
    }

    private String name;

    private String city;
    private String street;
    private int number;
    private List<CinemaHall> list;

    public Cinema(Long id, String name, String city, String street, int number) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Cinema(String name, String city, String street, List<CinemaHall> list) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.list = list;
    }

    public List<CinemaHall> getList() {
        return list;
    }

    public void setList(List<CinemaHall> list) {
        this.list = list;
    }

    public Cinema() {
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}