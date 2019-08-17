package services;

import abstractions.SelectCinemaInterface;
import comparators.CinemaComparatorByRatingDESC;
import entities.reservation.Cinema;
import entities.reservation.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectCinemaService implements SelectCinemaInterface {

    private List<Cinema> cinemaList;

    public SelectCinemaService() {
        this.cinemaList = new ArrayList<>();
    }

    public SelectCinemaService(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public SelectCinemaService addCinema(Cinema cinema) {
        cinemaList.add(cinema);
        return this;
    }

    public void sortCinemasByRating() {
        cinemaList.sort(new CinemaComparatorByRatingDESC());
    }


    /**
     * it doesn`t matter from what cinema we are getting movie list, so we`re getting it from the first
     */
    public List<Movie> getMoviesOfCategory(String category) {
        return cinemaList.get(0).getMovieList().stream()
                .filter(movie -> movie.ofCategory(category))
                .collect(Collectors.toList());
    }

    @Override
    public String showListOfCinemas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= cinemaList.size(); i++) {
            sb.append(i + ". " + cinemaList.get(i - 1) + "\n");
        }
        return sb.toString();
    }

    @Override
    public List<Movie> getMovieListInCinema(int indexOfCinema) {
        return cinemaList.get(indexOfCinema).getMovieList();
    }

    @Override
    public String showSessionListInCinema(int indexOfCinema) {
        return cinemaList.get(indexOfCinema).getListOfShowings();
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }
}
