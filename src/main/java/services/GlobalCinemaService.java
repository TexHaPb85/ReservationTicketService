package services;

import entities.User;

import java.util.Scanner;

public class GlobalCinemaService {
    public static User currentUser;

    private UserService userService;
    private BookingService bookingService;
    private Scanner scanner;

    public GlobalCinemaService() {
        currentUser=new User();
        scanner = new Scanner(System.in);

        userService=new UserService();
        bookingService= new BookingService(scanner);
    }

    public boolean start() {
        System.out.println("Hello, "+currentUser.getLogin()+", choose the option:\n" +
                "0. Log in.\n"+
                "1. Select cinema and see its movie list.\n" +
                "2. Search movies by category\n" +
                "3. Book places for a movie\n"+
                "4. Show my booking list\n"+
                "7. Sign up\n"+
                "9. Exit");
        switch (scanner.next()) {
            case "0":
                userService.logIn(scanner);
                break;
            case "1":
                bookingService.chooseCinemaAndBookMovie();
                break;
            case "2":
                bookingService.chooseCategory();
                break;
            case "3":
                bookingService.chooseCinemaAndBookMovie();
                break;
            case "4":
                currentUser.showBookingList();
                break;
            case "7":
                userService.registerNewUser(scanner);
                userService.logIn(scanner);
                break;
            case "9":
                return false;
            default:
                System.out.println("wrong option");
        }
        start();
        return true;
    }

    private void seeBookinglistOfUser(){
        System.out.println();
    }


}
