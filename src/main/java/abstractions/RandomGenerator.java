package abstractions;

import entities.reservation.Cinema;
import entities.reservation.Hall;
import entities.reservation.Movie;

import java.util.Arrays;
import java.util.List;

public interface RandomGenerator {

    List<Movie> getRandomMovieList();

    List<Cinema> getCinemaList();

    List<String> classicHallNumbers = Arrays.asList("A1","A2","A3","B1","B2","B3","C1","C2","C3");

    default int intRandom(int from, int to){
        return (int) (from+Math.random()*(to-from));
    }

    default double getRandomDouble(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
