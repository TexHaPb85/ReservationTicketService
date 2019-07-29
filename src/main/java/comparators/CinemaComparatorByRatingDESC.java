package comparators;

import entities.reservation.Cinema;

import java.util.Comparator;

public class CinemaComparatorByRatingDESC implements Comparator<Cinema> {
        @Override
        public int compare(Cinema o1, Cinema o2) {
            return (int) ((o2.getRating()*100)-(o1.getRating()*100));
        }
}
