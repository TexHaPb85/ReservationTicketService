package utilities;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import abstractions.RandomGenerator;
import entities.reservation.Cinema;
import entities.reservation.Hall;
import entities.reservation.Movie;

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
                //new DurationOfMovie(),
                Stream.of("Comedy", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Star Wars",
                TypeOfMovie.Translated,
                StatusOfMovie.prePremiere,
               // new DurationOfMovie(),
                Stream.of("Action", "Fantasy", "Drama").collect(Collectors.toList())));
        movies.add(new Movie("Game of Thrones",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                //new DurationOfMovie(),
                Stream.of("Horror", "Action", "Fantasy", "Historical").collect(Collectors.toList())));
        movies.add(new Movie("Terminator",
                TypeOfMovie.Translated,
                StatusOfMovie.available,
                //new DurationOfMovie(),
                Stream.of("Drama", "Action", "Fantasy").collect(Collectors.toList())));
        movies.add(new Movie("Zombie",
                TypeOfMovie.Original,
                StatusOfMovie.premiere,
                //new DurationOfMovie(),
                Stream.of("Horror", "Action", "Fantasy").collect(Collectors.toList())));

    }

    private void setCinemas(){
        cinemas=new ArrayList<>();
        cinemas.add(new Cinema("Batterfly", "Vadyma Getmana str. 43", 4.4, getRandomMovieList(),getHallsList()));
        cinemas.add(new Cinema("Leypcig", "Cosmosa Heroes str. 23", 4.1, getRandomMovieList(),getHallsList()));
        cinemas.add(new Cinema("Ocean Plaza", "Teremky str. 42", 4.8, getRandomMovieList(),getHallsList()));
        cinemas.add(new Cinema("Kino Dom", "Garmatna str. 39", 4.9, getRandomMovieList(),getHallsList()));
        cinemas.add(new Cinema("BloKino", "Shevchenka str. 77", 4.9, getRandomMovieList(),getHallsList()));
    }

    private List<Hall> getHallsList(){
        List<Hall> halls = new ArrayList<>();
        classicHallNumbers.stream().limit(intRandom(3,9)).forEach(hallName->{
            int amountOfPlaces = intRandom(4,14)*10;
            halls.add(new Hall(hallName,amountOfPlaces));
        });
        return halls;
    }

    @Override
    public List<Movie> getRandomMovieList() {
        int minSizeOfList = 2;
        int sizeOfRandomMovieList = (int) (Math.random() * movies.size()) +minSizeOfList;
        return movies.stream().limit(sizeOfRandomMovieList).collect(Collectors.toList());
    }

    @Override
    public List<Cinema> getCinemaList() {
        //int sizeOfRandomMovieList = (int) (Math.random() * cinemas.size()) +minSizeOfList;
        return cinemas;

    }

}
