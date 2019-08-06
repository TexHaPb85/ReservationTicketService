package entities.reservation;

import java.time.LocalDateTime;

public class ScheduledMovie {
    private LocalDateTime showingDate;
    private Cinema cinemaOfMovie;
    private Hall hallOfMovie;
    private Movie showingMovie;

    public ScheduledMovie(LocalDateTime showingDate, Cinema cinemaOfMovie, Hall hallOfMovie, Movie showingMovie) {
        this.showingDate = showingDate;
        this.cinemaOfMovie = cinemaOfMovie;
        this.hallOfMovie = hallOfMovie;
        this.showingMovie = showingMovie;
    }

    public LocalDateTime getShowingDate() {
        return showingDate;
    }

    public void setShowingDate(LocalDateTime showingDate) {
        this.showingDate = showingDate;
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

    public Movie getShowingMovie() {
        return showingMovie;
    }

    public void setShowingMovie(Movie showingMovie) {
        this.showingMovie = showingMovie;
    }

    @Override
    public String toString() {
        return showingMovie.getName() + " date: " + showingDate + " hall:" + hallOfMovie.getNumber();
    }
}
