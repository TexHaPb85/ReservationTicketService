package entities;

import Enums.StatusOfMovie;

public class Movie {
    private String name;
    private int numberOfRoom;
    private boolean isTranslated;//type of movie(original, translated)
    private StatusOfMovie status;//status of movie(pre-premiere, premiere,  available)
    private DurationOfMovie duration;//duration of movie show( from, to)

    public Movie(String name, int numberOfRoom, boolean isTranslated, DurationOfMovie duration) {
        this.name = name;
        this.numberOfRoom = numberOfRoom;
        this.isTranslated = isTranslated;
        status=status.available;//???????????
        this.duration = duration;
    }

    @Override
    public String toString() {
        return  name + '\'' +
                ", numberOfRoom=" + numberOfRoom +
                ", isTranslated=" + isTranslated +
                ", duration=" + duration +
                '}';
    }
}
