package services;

import Enums.Constants;
import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import abstractions.RandomGenerator;
import entities.DurationOfMovie;
import entities.Movie;

import java.util.Random;

public class RandomGeneratorService implements RandomGenerator {
    private String[] randomMovieNames;
    private String[] categories;

    public RandomGeneratorService() {
        randomMovieNames = new String[]{"Avangers", "Star Wars", "Terminator", "Iron Man", "Helloween",
                "Robocop", "American Pie", "Scholars", "Zombie"};

        categories=
    }

    private StatusOfMovie getRandomStatus() {
        Random r = new Random();
        StatusOfMovie status;
        int rand = r.nextInt(3);
        switch (rand) {
            case 0: {
                status = StatusOfMovie.prePremiere;
                break;
            }
            case 1: {
                status = StatusOfMovie.premiere;
                break;
            }
            case 2: {
                status = StatusOfMovie.available;
                break;
            }
            default: {
                status = StatusOfMovie.defaultStatus;
                break;
            }
        }
        return status;
    }

    private double getRandomDouble(double min, double max){
        return min+Math.random()*(max-min);
    }


    @Override
    public Movie getRandomCinema() {
        String name = randomMovieNames[intRandom(0, randomMovieNames.length)] + " " + intRandom(Constants.MIN_PART_OF_MOVIE, 9);
        TypeOfMovie type;
        if (intRandom(0, 1) > 0) {
            type = TypeOfMovie.Original;
        } else {
            type = TypeOfMovie.Translated;
        }
        return new Movie(name, intRandom(100, 400), type, getRandomStatus(),new DurationOfMovie(),getRandomDouble(40,100),);
    }

}
