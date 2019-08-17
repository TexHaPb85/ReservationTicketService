package abstractions;

import entities.reservation.Cinema;
import entities.reservation.Movie;

import java.util.Arrays;
import java.util.List;

public interface CinemaGenerator {

    int MIN_NUMBER_OF_HALLS_IN_CINEMA = 3;
    int MAX_NUMBER_OF_HALLS_IN_CINEMA = 9;
    int MIN_AMOUNT_OF_ROWS = 4;
    int MAX_AMOUNT_OF_ROWS = 14;
    int MIN_PRICE_DIVIDED_BY_10 = 4;
    int MAX_PRICE_DIVIDED_BY_10 = 10;
    int NUMBER_OF_PLACES_IN_ONE_ROW = 10;

    int VIP_PLACES_DIVIDER = 8;
    int PREMIUM_PLACES_DIVIDER = 2;

    List<String> classicHallNumbers = Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3");

    List<Movie> getRandomMovieList();

    List<Cinema> getCinemaList();
}
