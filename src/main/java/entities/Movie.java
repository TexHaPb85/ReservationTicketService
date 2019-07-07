package entities;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import utilities.DurationOfMovie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Movie {
    private String name;
    private int numberOfRoom;
    private TypeOfMovie isTranslated;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-premiere, premiere,  available)
    private DurationOfMovie duration;//duration of movie show( from, to)
    private double priceOfTicket;
    private List<String> categories;

    public Movie(String name, int numberOfRoom, TypeOfMovie isTranslated,
                 StatusOfMovie status, DurationOfMovie duration, double priceOfTicket) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
        this.isTranslated = isTranslated;
        this.status = status;
        this.duration = duration;
        this.priceOfTicket = priceOfTicket;
        this.categories = new ArrayList<>();
    }

    public Movie(String name, TypeOfMovie isTranslated, StatusOfMovie status, DurationOfMovie duration,
                 double priceOfTicket, List<String> categories) {
        Random random = new Random();
        this.numberOfRoom = random.nextInt(13);
        this.name = name;
        this.isTranslated = isTranslated;
        this.duration = duration;
        this.priceOfTicket = priceOfTicket;
        this.categories = categories;
        this.status = status;
    }

    public boolean ofCategory(String category){
        return categories.contains(category);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + categories +
                "\tnumberOfHall:" + numberOfRoom +
                "\tTime of beginning:" + duration.fromTime +
                "\tTime of ending:" + duration.toTime +
                "\tprice of ticket:" + (int) priceOfTicket +
                "\tLanguage:" + isTranslated+
                "\tStatus"+status;


    }
}
