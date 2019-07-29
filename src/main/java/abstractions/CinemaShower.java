package abstractions;

import entities.reservation.Movie;

import java.util.List;

public interface CinemaShower {

    String getListOfCinemas();

    String getListOfFilmsByIndex(int numberOfCinema);

    List<Movie> getMovieListInCinma(int indexOfCinema);
}
