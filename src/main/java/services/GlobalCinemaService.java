package services;

import entities.Cinema;
import utilities.RandomMovieGenerator;

import java.util.Scanner;

public class GlobalCinemaService {
    private SelectCinemaService selectCinemaService;
    private RandomMovieGenerator randomService;
    private Scanner scanner;

    public GlobalCinemaService() {
        selectCinemaService = new SelectCinemaService();
        randomService = new RandomMovieGenerator();
        scanner = new Scanner(System.in);

        selectCinemaService.addCinema(new Cinema("Batterfly", "Vadyma Getmana str. 43", 4.4, randomService.getRandomMovieList())).
                addCinema(new Cinema("Leypcig", "Cosmosa Heroes str. 23", 4.1, randomService.getRandomMovieList())).
                addCinema(new Cinema("Ocean Plaza", "Teremky str. 42", 4.8, randomService.getRandomMovieList()));
    }

    public void chooseCinema() {
        System.out.println("Would you like to sort cinemas by rating before show them?(yes/no)");
        if(scanner.next().equals("yes"))
            selectCinemaService.sortCinemasByRating();
        System.out.println("Choose the cinema:");
        System.out.println(selectCinemaService.getListOfCinemas());
        System.out.println(selectCinemaService.getListOfFilmsInSelectedCinema(scanner.nextInt() - 1));
    }

    public void chooseCategory() {
        System.out.println("Enter category");
        String category = scanner.next();
        selectCinemaService.getMoviesOfCategory(category).forEach(System.out::println);
    }

    public void choosePlaces() {
        System.out.println("Developing...");
    }

    public boolean demo() {
        System.out.println("Choose the option:\n" +
                "1. Select cinema and see its movie list.\n" +
                "2. Search movies by category\n" +
                "3. Select places");
        switch (scanner.next()) {
            case "1":
                chooseCinema();
                break;
            case "2":
                chooseCategory();
                break;
            case "3":
                choosePlaces();
                break;
            default:
                System.out.println("wrong option");
                return false;
        }
        demo();
        return true;
    }
}
