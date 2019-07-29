package services;

import entities.User;
import entities.reservation.Booking;
import entities.reservation.Cinema;
import entities.reservation.MovieShowing;
import entities.reservation.Place;
import utilities.RandomListGenerator;

import java.util.Scanner;

public class BookingService {
    private SelectCinemaService selectCinemaService;
    private Scanner scanner;

    private int currentBookingId = 0;

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
        System.out.println(selectCinemaService.showListOfCinemas());

        int indexOfCinema = scanner.nextInt() - 1;
        Cinema cinema = selectCinemaService.getCinemaList().get(indexOfCinema);
        System.out.println(selectCinemaService.showShowingListInCinema(indexOfCinema));


        int indexOfMovieShowing = scanner.nextInt() - 1;
        MovieShowing showing = cinema.getDailyMovieSchedule().get(indexOfMovieShowing);
        bookFilm(showing,GlobalCinemaService.currentUser,scanner);

    }

    public void chooseCategory() {
        System.out.println("Enter category");
        String category = scanner.next();
        selectCinemaService.getMoviesOfCategory(category).forEach(System.out::println);
    }

    public void bookFilm(MovieShowing showing, User booker, Scanner scanner) {
        System.out.println("Hello, " + booker.getLogin() + " you want to make booking of" + showing.toString());
        System.out.println("Please select place, enter its number:");
        showing.getHallOfMovie().showBookedPlaces();
        int numberOfBookingPlace = scanner.nextInt();
        Place place = showing.getHallOfMovie().bookPlaceByNumber(numberOfBookingPlace);
        System.out.println("Please enter info of your credit card to make a payment, or enter '-', if you want to pay it later");
        String creditCardInfo = scanner.next();
        boolean isPaid = false;
        if(creditCardInfo.length()>19){
            System.out.println("you entered wrong credit card, you can pay it later");
        }else {
            System.out.println("booking successful!");
            isPaid=true;
        }
        Booking booking = new Booking(currentBookingId++,isPaid, place, showing);
        booker.addBookings(booking);
    }
}
