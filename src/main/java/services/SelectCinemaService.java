package services;

import abstractions.CinemaListShower;
import entities.Cinema;

import java.util.ArrayList;
import java.util.List;

public class SelectCinemaService implements CinemaListShower {
    private List<Cinema> cinemaList;

    public SelectCinemaService() {
        this.cinemaList = new ArrayList();
    }

    public SelectCinemaService addCinema(Cinema cinema){
        cinemaList.add(cinema);
        return this;
    }

    public void showListOfCinemas() {
        cinemaList.stream().forEach(System.out::println);
    }

    public void showListOfFilmsInSelectedCinema(int numberOfCinema) {
        System.out.println(cinemaList.get(numberOfCinema).getListOfMovies());
    }
}
