package services;

import entities.User;
import entities.reservation.Booking;
import utilities.RandomListGenerator;

import java.util.Scanner;

public class BookingService {
    private SelectCinemaService selectCinemaService;
    private Scanner scanner;

    public BookingService(Scanner scanner) {
        RandomListGenerator randomGenerator = new RandomListGenerator();

        this.selectCinemaService = new SelectCinemaService(randomGenerator.getCinemaList());
        this.scanner = scanner;
    }

    public void chooseCinema() {
        System.out.println("Would you like to sort cinemas by rating before show them?(yes/no)");
        if (scanner.next().contains("ye"))
            selectCinemaService.sortCinemasByRating();

        System.out.println("Choose the cinema:");
        System.out.println(selectCinemaService.getListOfCinemas());
        int indexOfCinema = scanner.nextInt() - 1;

        System.out.println(selectCinemaService.getListOfFilmsByIndex(indexOfCinema));
        int indexOfMovie = scanner.nextInt() - 1;
    }

    public void chooseCategory() {
        System.out.println("Enter category");
        String category = scanner.next();
        selectCinemaService.getMoviesOfCategory(category).forEach(System.out::println);
    }

    public void bookFilm(Booking booking, User booker) {
        System.out.println("Hello, " + booker.getLogin() + " your booking: \n");
        System.out.println(booking.toString());
        booker.addBookings(booking);
    }
}
