package services;

import entities.User;

import java.util.Scanner;

public class GlobalCinemaService {
    public static User currentUser;

    private UserService userService;
    private BookingService bookingService;
    private Scanner scanner;

    public GlobalCinemaService() {
        currentUser = new User();
        scanner = new Scanner(System.in);

        userService = new UserService();
        bookingService = new BookingService(scanner);
    }

    public boolean start() {
        System.out.println("Hello, " + currentUser.getLogin() + ", choose the option:\n" +
                "1. Sign in.\n" +
                "2. Select cinema and see its movie list.\n" +
                "3. Search movies by category\n" +
                "4. Book places for a movie\n" +
                "5. Show my booking list\n" +
                "6. Sign up\n" +
                "7. Pay unpaid bookings\n" +
                "8. Set additional info\n" +
                "9. Exit");
        switch (scanner.next()) {
            case "1":
                userService.logIn(scanner);
                break;
            case "2":
                bookingService.chooseCinemaAndBookMovie();
                break;
            case "3":
                bookingService.chooseCategory();
                break;
            case "4":
                bookingService.chooseCinemaAndBookMovie();
                break;
            case "5":
                currentUser.showBookingList(scanner);
                break;
            case "6":
                userService.registerNewUser(scanner);
                userService.logIn(scanner);
                break;
            case "7":
                currentUser.payUnpaidBookings(scanner);
                break;
            case "8":
                currentUser.setAditionalInfo(scanner);
            case "9":
                return false;
            default:
                System.out.println("wrong option");
        }
        start();
        return true;
    }

    private void seeBookinglistOfUser() {
        System.out.println();
    }


}
