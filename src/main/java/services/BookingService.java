package services;

import entities.User;
import entities.reservation.*;
import utilities.CreditCardChecker;
import utilities.RandomListGenerator;

import java.util.List;
import java.util.Scanner;

public class BookingService {
    private SelectCinemaService selectCinemaService;
    private Scanner scanner;

    private final int INITIAL_ID_VALUE = 1;
    private int currentBookingId = INITIAL_ID_VALUE;

    public BookingService(Scanner scanner) {
        RandomListGenerator randomGenerator = new RandomListGenerator();

        this.selectCinemaService = new SelectCinemaService(randomGenerator.getCinemaList());
        this.scanner = scanner;
    }

    public void chooseCinemaAndBookMovie() {
        System.out.println("Would you like to sort cinemas by rating before show them?(yes/no)");
        if (scanner.next().toLowerCase().contains("ye"))
            selectCinemaService.sortCinemasByRating();

        System.out.println("Choose the cinema:");
        System.out.println(selectCinemaService.showListOfCinemas());
        int indexOfCinema = scanner.nextInt() - 1;
        Cinema cinema = selectCinemaService.getCinemaList().get(indexOfCinema);
        System.out.println(selectCinemaService.showShowingListInCinema(indexOfCinema));

        int indexOfMovieShowing = scanner.nextInt() - 1;
        if (indexOfMovieShowing >= 0) {
            ScheduledMovie showing = cinema.getDailyMovieSchedule().get(indexOfMovieShowing);
            if (GlobalCinemaService.currentUser.isAbleToBook() && GlobalCinemaService.currentUser.isAuthorized()) {
                bookMovieShowing(showing, GlobalCinemaService.currentUser, scanner);
            } else {
                System.out.println("you haven`t authorized or you have more then 2 unpaid booking");
            }
        }
    }

    public void chooseCategory() {
        System.out.println("Enter category");
        String category = scanner.next();
        List<Movie> moviesOfCategory = selectCinemaService.getMoviesOfCategory(category);
        if (moviesOfCategory.isEmpty()) {
            System.out.println("There are no films of category " + category);
        } else {
            moviesOfCategory.forEach(System.out::println);
        }
    }

    public void bookMovieShowing(ScheduledMovie showing, User booker, Scanner scanner) {
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
            System.out.println("Can`t find credit card, you can pay this booking later fro1m main menu");
            System.out.println(booking.toString());
            System.out.println("added to your booking list as unpaid");
            System.out.println("------------------------------------\n");
        } else {
            System.out.println("booking successful!");
            System.out.println(booking.toString());
            System.out.println("added to your booking list\n");
        }
        /*ParallelBooker parallelBooker = new ParallelBooker(showing, booker, scanner, currentBookingId++);
        Thread thread = new Thread(parallelBooker);
        thread.start();*/
    }
}
