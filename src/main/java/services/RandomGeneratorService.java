package services;

import abstractions.RandomGenerator;
import entities.Cinema;
import entities.Movie;

public class RandomGeneratorService implements RandomGenerator {
    private String[] randomMovieNames;

    public RandomGeneratorService() {
        randomMovieNames=new String[]{"Avangers", "Star Wars","Terminator","Iron Man", "Helloween",
                "Robocop","American Pie", "Scholars", "Zombie"};
    }


    @Override
    public Movie getRandomCinema() {
        String name = randomMovieNames[intRandom(0,randomMovieNames.length)]+" "+String.valueOf(intRandom(1,9));
        return new Movie();
    }

}
