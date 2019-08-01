package services;

import entities.User;
import entities.reservation.Cinema;
import entities.reservation.Movie;
import entities.reservation.MovieShowing;
import utilities.RandomListGenerator;

import java.util.List;
import java.util.Scanner;

public class BookingService {
    private SelectCinemaService selectCinemaService;
    private Scanner scanner;

    private int currentBookingId = 1;

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
            MovieShowing showing = cinema.getDailyMovieSchedule().get(indexOfMovieShowing);
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

    public void bookMovieShowing(MovieShowing showing, User booker, Scanner scanner) {
        ParallelBooker parallelBooker = new ParallelBooker(showing, booker, scanner, currentBookingId++);
        parallelBooker.start();
    }
}
