package abstractions;

import entities.Movie;

public interface RandomGenerator {

    Movie getRandomCinema();

    default int intRandom(int from, int to){
        return (int) (from+Math.random()*(to-from));
    }
}
