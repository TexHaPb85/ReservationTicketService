package utilities;

import entities.Cinema;

import java.util.Comparator;

public class Comparators {
    public static class CinemaComparatorByRatingDESC implements Comparator<Cinema> {
        @Override
        public int compare(Cinema o1, Cinema o2) {
            return (int) ((o2.getRating()*100)-(o1.getRating()*100));
        }
    }
}
