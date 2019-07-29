package abstractions;

import entities.reservation.Movie;

import java.util.List;

public interface CinemaShower {

    String showListOfCinemas();

    String showShowingListInCinema(int numberOfCinema);

    List<Movie> getMovieListInCinema(int indexOfCinema);
}
