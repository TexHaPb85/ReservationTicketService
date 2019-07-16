package services;

import abstractions.CinemaShower;
import entities.Cinema;
import entities.Movie;
import comparators.CinemaComparatorByRatingDESC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectCinemaService implements CinemaShower {
    private List<Cinema> cinemaList;

    public SelectCinemaService() {
        this.cinemaList = new ArrayList();
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
    public String getListOfFilmsInSelectedCinema(int numberOfCinema) {
        return cinemaList.get(numberOfCinema).getListOfMovies();
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }
}
