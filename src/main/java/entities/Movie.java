package entities;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;

public class Movie {
    private String name;
    private int numberOfRoom;
    private TypeOfMovie isTranslated;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-premiere, premiere,  available)
    private DurationOfMovie duration;//duration of movie show( from, to)
    private double priceOfTiket;
    private String category;

    public Movie(String name, int numberOfRoom, TypeOfMovie isTranslated, StatusOfMovie status, DurationOfMovie duration, double priceOfTiket, String category) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
        this.isTranslated = isTranslated;
        this.status = status;
        this.duration = duration;
        this.priceOfTiket = priceOfTiket;
        this.category = category;
    }
}
