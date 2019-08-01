package entities.reservation;

import Enums.StatusOfMovie;
import Enums.TypeOfMovie;

import java.util.List;

public class Movie {
    private String name;
    private TypeOfMovie ifTranslated;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-premiere, premiere,  available)
    private List<String> categories;

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

    public StatusOfMovie getStatus() {
        return status;
    }

    public void setStatus(StatusOfMovie status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name + categories +
                "\tLanguage: " + ifTranslated +
                "\tStatus: " + status +
                "\t" + status;
    }
}
