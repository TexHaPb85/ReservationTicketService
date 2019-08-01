package services;

import entities.User;
import entities.reservation.Booking;
import entities.reservation.MovieShowing;
import entities.reservation.Place;
import utilities.CreditCardChecker;

import java.util.Scanner;

public class ParallelBooker implements Runnable {
    private MovieShowing showing;
    private User booker;
    private Scanner scanner;
    private int currentBookingId;

    public ParallelBooker(MovieShowing showing, User booker, Scanner scanner, int currentBookingId) {
        this.showing = showing;
        this.booker = booker;
        this.scanner = scanner;
        this.currentBookingId = currentBookingId;
    }

    private synchronized void book() {
        System.out.println("booking from thread: " + Thread.currentThread());

        System.out.println("Hello, " + booker.getLogin() + " you want to make booking of '" + showing.toString() + "'");
        System.out.println("Please select place, enter its number:(e.g. 3 is number of V3, 38 is number of N38 etc.)");
        showing.getHallOfMovie().showBookedPlaces();
        int numberOfBookingPlace = scanner.nextInt();
        Place place = showing.getHallOfMovie().bookPlaceByNumber(numberOfBookingPlace);
        place.setDiscountPrice(showing, GlobalCinemaService.currentUser);

        System.out.println(place.getPrice() + " to pay");
        System.out.println("Please enter info of your credit card to make a payment, or enter '-', if you want to pay it later");
        System.out.println("format of info: 5355-****-****-2501_08:21_243");
        String creditCardInfo = scanner.next();
        boolean isPaid = CreditCardChecker.isCorrectCardInfo(creditCardInfo);
        Booking booking = new Booking(currentBookingId++, isPaid, place, showing);
        booker.addBookings(booking);

        if (!isPaid) {
            System.out.println("you entered wrong credit card, you can pay it later");
            System.out.println(booking.toString());
            System.out.println("added to your booking list as unpaid");
            System.out.println("------------------------------------\n");
        } else {
            System.out.println("booking successful!");
            System.out.println(booking.toString());
            System.out.println("added to your booking list\n");
        }
    }

    @Override
    public void run() {
        book();
    }
}
