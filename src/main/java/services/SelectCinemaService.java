package services;

import abstractions.CinemaShower;
import entities.reservation.Cinema;
import entities.reservation.Movie;
import comparators.CinemaComparatorByRatingDESC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectCinemaService implements CinemaShower {

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

    public void sortCinemasByRating(){
        cinemaList.sort(new CinemaComparatorByRatingDESC());
    }

    public List<Movie> getMoviesOfCategory(String category) {
        return cinemaList.get(0)
                .getMovieList()
                .stream()
                .filter(movie -> movie.ofCategory(category))
                .collect(Collectors.toList());
    }

    @Override
    public String getListOfCinemas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= cinemaList.size(); i++) {
            sb.append(i + ". " + cinemaList.get(i - 1) + "\n");
        }
        return sb.toString();
    }

    @Override
    public List<Movie> getMovieListInCinma(int indexOfCinema) {
        return cinemaList.get(indexOfCinema).getMovieList();
    }

    @Override
    public String getListOfFilmsByIndex(int indexOfCinema) {
        return cinemaList.get(indexOfCinema).getListOfMovies();
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }
}
