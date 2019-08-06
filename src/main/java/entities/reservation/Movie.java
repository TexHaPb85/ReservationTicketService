package entities.reservation;

import enums.StatusOfMovie;
import enums.TypeOfMovie;

import java.util.List;

public class Movie {
    private String name;
    private TypeOfMovie typeOfMovie;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-PREMIERE, PREMIERE,  AVAILABLE)
    private List<String> categories;

    public Movie(String name, TypeOfMovie typeOfMovie, StatusOfMovie status, List<String> categories) {
        this.name = name;
        this.typeOfMovie = typeOfMovie;
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
                "\tLanguage: " + typeOfMovie +
                "\tStatus: " + status +
                "\t" + status;
    }
}
