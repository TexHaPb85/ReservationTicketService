package entities.reservation;

import java.time.LocalDateTime;

/**
 * бронювання
 */
public class Booking {
    private int id;
    private boolean isPaid;
    private Place place;
    private LocalDateTime bookedDate;
    private LocalDateTime lastDayOfPayment;
    private ScheduledMovie scheduledMovie;

    public Booking(int id, boolean isPaid, Place place, ScheduledMovie scheduledMovie) {
        bookedDate = LocalDateTime.now();
        lastDayOfPayment = scheduledMovie.getShowingDate().minusHours(5);
        this.id = id;
        this.isPaid = isPaid;
        this.place = place;
        this.scheduledMovie = scheduledMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public ScheduledMovie getScheduledMovie() {
        return scheduledMovie;
    }

    public void setScheduledMovie(ScheduledMovie scheduledMovie) {
        this.scheduledMovie = scheduledMovie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Booking ");
        sb.append("id: " + id);
        if (isPaid) {
            sb.append(" is paid, price: " + place.getPrice());
        } else {
            sb.append(" not paid, to pay: " + place.getPrice());
            sb.append("\nlast day of payment: " + lastDayOfPayment);
        }
        sb.append("\n******************************");
        sb.append("\nMovie: " + scheduledMovie.getShowingMovie().getName());
        sb.append("\n******************************");
        sb.append("\nDate: " + scheduledMovie.getShowingDate());
        sb.append("\nCinema: " + scheduledMovie.getCinemaOfMovie().getName());
        sb.append("\nHall: " + scheduledMovie.getHallOfMovie().getNumber());
        sb.append("\nPlace: " + place.getType() + ", number:" + place.getPlaceNumber() + "\n");

        return sb.toString();
    }
}
