package abstractions;

import entities.reservation.Movie;

import java.util.List;

public interface SelectCinemaInterface {

    String showListOfCinemas();

    String showSessionListInCinema(int numberOfCinema);

    List<Movie> getMovieListInCinema(int indexOfCinema);
}
