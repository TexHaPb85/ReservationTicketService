package abstractions;

import entities.Movie;

import java.util.List;

public interface RandomGenerator {

    List<Movie> getRandomMovieList();

    default int intRandom(int from, int to){
        return (int) (from+Math.random()*(to-from));
    }
    default double getRandomDouble(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
