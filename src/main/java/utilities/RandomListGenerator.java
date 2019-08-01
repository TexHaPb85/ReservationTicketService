package utilities;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import abstractions.RandomGenerator;
import entities.reservation.Cinema;
import entities.reservation.Hall;
import entities.reservation.Movie;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomListGenerator implements RandomGenerator {

    private List<Movie> movies;
    private List<Cinema> cinemas;

    public RandomListGenerator() {
        setMovies();
        setCinemas();
    }

    private void setMovies() {
        movies = new ArrayList<>();
        movies.add(new Movie("Avangers",
                TypeOfMovie.Translated,
                StatusOfMovie.prePremiere,
                Stream.of("Comedy", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Star Wars",
                TypeOfMovie.Translated,
                StatusOfMovie.prePremiere,
                Stream.of("Action", "Fantasy", "Drama").collect(Collectors.toList())));
        movies.add(new Movie("Game of Thrones",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                Stream.of("Horror", "Action", "Fantasy", "Historical").collect(Collectors.toList())));
        movies.add(new Movie("Terminator",
                TypeOfMovie.Translated,
                StatusOfMovie.available,
                Stream.of("Drama", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Zombie",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                Stream.of("Horror", "Action", "Fantasy").collect(Collectors.toList())));

    }

    private void setCinemas() {
        cinemas = new ArrayList<>();
        cinemas.add(new Cinema("Batterfly", "Vadyma Getmana str. 43", 4.4, getRandomMovieList(), getHallsList()));
        cinemas.add(new Cinema("Leypcig", "Cosmosa Heroes str. 23", 4.1, getRandomMovieList(), getHallsList()));
        cinemas.add(new Cinema("Ocean Plaza", "Teremky str. 42", 4.8, getRandomMovieList(), getHallsList()));
        cinemas.add(new Cinema("Kino Dom", "Garmatna str. 39", 4.9, getRandomMovieList(), getHallsList()));
        cinemas.add(new Cinema("BloKino", "Shevchenka str. 77", 4.9, getRandomMovieList(), getHallsList()));
    }

    private List<Hall> getHallsList() {
        List<Hall> halls = new ArrayList<>();
        int numberOfHallsInCinema = intRandom(MIN_NUMBER_OF_HALLS_IN_CINEMA, MAX_NUMBER_OF_HALLS_IN_CINEMA);
        classicHallNumbers.stream().limit(numberOfHallsInCinema).forEach(hallName -> {
            int amountOfPlaces = intRandom(MIN_AMOUNT_OF_ROWS, MAX_AMOUNT_OF_ROWS) * NUMBER_OF_PLACES_IN_ONE_ROW;
            BigDecimal price = new BigDecimal(intRandom(MIN_PRICE_DIVIDED_BY_10, MAX_PRICE_DIVIDED_BY_10) * 10);
            halls.add(new Hall(hallName, amountOfPlaces, price));
        });
        return halls;
    }

    @Override
    public List<Movie> getRandomMovieList() {
        return movies;
    }

    @Override
    public List<Cinema> getCinemaList() {
        return cinemas;

    }

}
