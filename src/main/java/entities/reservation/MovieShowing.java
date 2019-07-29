package entities.reservation;

import java.time.LocalDate;

public class MovieShowing {
    private LocalDate bookedDate;
    private Cinema cinemaOfMovie;
    private Hall hallOfMovie;
    private Movie bookedMovie;

    public MovieShowing(LocalDate bookedDate, Cinema cinemaOfMovie, Hall hallOfMovie, Movie bookedMovie) {
        this.bookedDate = bookedDate;
        this.cinemaOfMovie = cinemaOfMovie;
        this.hallOfMovie = hallOfMovie;
        this.bookedMovie = bookedMovie;
    }

    public LocalDate getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(LocalDate bookedDate) {
        this.bookedDate = bookedDate;
    }

    public Cinema getCinemaOfMovie() {
        return cinemaOfMovie;
    }

    public void setCinemaOfMovie(Cinema cinemaOfMovie) {
        this.cinemaOfMovie = cinemaOfMovie;
    }

    public Hall getHallOfMovie() {
        return hallOfMovie;
    }

    public void setHallOfMovie(Hall hallOfMovie) {
        this.hallOfMovie = hallOfMovie;
    }

    public Movie getBookedMovie() {
        return bookedMovie;
    }

    public void setBookedMovie(Movie bookedMovie) {
        this.bookedMovie = bookedMovie;
    }
}
