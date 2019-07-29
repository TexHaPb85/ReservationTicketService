package entities.reservation;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;
import utilities.DurationOfMovie;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private TypeOfMovie ifTranslated;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-premiere, premiere,  available)
    private DurationOfMovie duration;//duration of movie show( from, to)
    private List<String> categories;

    public Movie(String name, TypeOfMovie ifTranslated, StatusOfMovie status, DurationOfMovie duration) {
        this.name = name;
        this.ifTranslated = ifTranslated;
        this.status = status;
        this.duration = duration;
        this.categories = new ArrayList<>();
    }

    public Movie(String name, TypeOfMovie ifTranslated, StatusOfMovie status, DurationOfMovie duration,
                 List<String> categories) {
        this.name = name;
        this.ifTranslated = ifTranslated;
        this.duration = duration;
        this.categories = categories;
        this.status = status;
    }

    public Movie(String name, TypeOfMovie ifTranslated, StatusOfMovie status, List<String> categories) {
        this.name = name;
        this.ifTranslated = ifTranslated;
        this.categories = categories;
        this.status = status;
    }

    public boolean ofCategory(String category) {
        return categories.stream().anyMatch(c -> c.equalsIgnoreCase(category));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + categories +
                //"\tTime of beginning: " + duration.fromTime +
                //"\tTime of ending: " + duration.toTime +
                "\tLanguage: " + ifTranslated +
                "\tStatus: " + status +
                "\t" + status;
    }
}
