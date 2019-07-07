package utilities;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import abstractions.RandomGenerator;
import entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomMovieGenerator implements RandomGenerator {

    private List<Movie> movies;

    public RandomMovieGenerator() {
        setMovies();
    }

    public void setMovies() {
        movies = new ArrayList<>();
        movies.add(new Movie("Avangers",
                TypeOfMovie.Translated,
                StatusOfMovie.prePremiere,
                new DurationOfMovie(),
                getRandomDouble(40, 100),
                Stream.of("Comedy", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Star Wars",
                TypeOfMovie.Translated,
                StatusOfMovie.prePremiere,
                new DurationOfMovie(),
                getRandomDouble(50, 120),
                Stream.of("Action", "Fantasy", "Drama").collect(Collectors.toList())));
        movies.add(new Movie("Game of Thrones",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                new DurationOfMovie(),
                getRandomDouble(40, 100),
                Stream.of("Horror", "Action", "Fantasy", "Historical").collect(Collectors.toList())));
        movies.add(new Movie("Terminator",
                TypeOfMovie.Translated,
                StatusOfMovie.available,
                new DurationOfMovie(),
                getRandomDouble(40, 100),
                Stream.of("Drama", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Zombie",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                new DurationOfMovie(),
                getRandomDouble(40, 100),
                Stream.of("Horror", "Action", "Fantasy").collect(Collectors.toList())));

    }

    @Override
    public List<Movie> getRandomMovieList() {
//        movies.remove(intRandom(0,movies.size()));
//        movies.remove(intRandom(0,movies.size()));
        return movies;
    }

}
