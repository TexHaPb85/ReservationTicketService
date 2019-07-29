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
                "7. Sign up\n"+
                "9. Exit");
        switch (scanner.next()) {
            case "0":
                userService.logIn(scanner);
                break;
            case "1":
                bookingService.chooseCinema();
                break;
            case "2":
                bookingService.chooseCategory();
                break;
            case "3":
                bookPlaces();
                break;
            case "7":
                register();
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

    private void bookPlaces() {
        System.out.println("Developing...");
    }

    private void register(){
        System.out.println("Enter your new login");
        String login = scanner.next();
        System.out.println("Enter your new password");
        String password = scanner.next();
        System.out.println("If you are student enter your student`s ticket number or if yor aren`t enter '-'");
        String tiketNum = scanner.next();
        userService.registerUser(new User(login,password,tiketNum));
    }
}
