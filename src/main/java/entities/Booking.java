package entities;

import java.util.Date;

/**
 * бронювання
 */
public class Booking {
    private String bookedDate;
    private boolean isPaid;
    private Movie bookedMovie;

    public Booking(String bookedDate, boolean isPaid, Movie bookedMovie) {
        this.bookedDate = bookedDate;
        this.isPaid = isPaid;
        this.bookedMovie = bookedMovie;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        this.bookedDate = bookedDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Movie getBookedMovie() {
        return bookedMovie;
    }

    public void setBookedMovie(Movie bookedMovie) {
        this.bookedMovie = bookedMovie;
    }
}
