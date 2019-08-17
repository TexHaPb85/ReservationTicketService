package entities.reservation;

import abstractions.CinemaGenerator;
import enums.TypeOfPlace;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hall {
    private String number;
    private int amountOfPlaces;
    private Map<Place, Boolean> bookedPlaces;

    public Hall(String number, int amountOfPlaces, BigDecimal normalTicketPrice) {
        this.bookedPlaces = new LinkedHashMap<>();
        this.number = number;
        this.amountOfPlaces = amountOfPlaces;

        fillBookedPlacesList(normalTicketPrice);
    }

    public Place bookPlaceByNumber(int number) {
/*        Place bookingPlace = new Place();
        for (Place place : bookedPlaces.keySet()) {
            if (place.getPlaceNumber() == number) {
                bookedPlaces.put(place, true);
                bookingPlace = place;
            }
        }
        return bookingPlace;*/

        return bookedPlaces.keySet().stream()
                .filter(place -> place.getPlaceNumber()==number)
                .peek(place -> bookedPlaces.put(place,true))
                .findFirst()
                .get();
    }

    private void fillBookedPlacesList(BigDecimal normalTicketPrice) {
        for (int i = 1; i <= amountOfPlaces; i++) {

            int vipPlacesLimit = amountOfPlaces / CinemaGenerator.VIP_PLACES_DIVIDER;
            int premiumPlacesLimit = amountOfPlaces / CinemaGenerator.PREMIUM_PLACES_DIVIDER;

            if (i < vipPlacesLimit) {
                BigDecimal priceOfTicket = normalTicketPrice.multiply(BigDecimal.valueOf(1.5));
                Place place = new Place(i, TypeOfPlace.VIP, priceOfTicket);
                bookedPlaces.put(place, false);
            } else if (i < premiumPlacesLimit) {
                BigDecimal priceOfTicket = normalTicketPrice.multiply(BigDecimal.valueOf(1.2));
                Place place = new Place(i, TypeOfPlace.PREMIUM, priceOfTicket);
                bookedPlaces.put(place, false);
            } else {
                Place place = new Place(i, TypeOfPlace.NORMAL, normalTicketPrice);
                bookedPlaces.put(place, false);
            }
        }
    }

    public void showBookedPlaces() {
        int numOfPlacesInOneRow = CinemaGenerator.NUMBER_OF_PLACES_IN_ONE_ROW;

        StringBuilder sb = new StringBuilder("\nHall: " + number + "\n");
        bookedPlaces.forEach((place, isBooked) -> {

            sb.append(!isBooked ?
                    place.getType().getSigh() + place.getPlaceNumber() + " "
                    : "#" + place.getPlaceNumber() + " ");

            if ((place.getPlaceNumber()) % numOfPlacesInOneRow == 0) {
                sb.append("\n");
            }
        });
        sb.append("############SCREEN#############");
        System.out.println(sb.toString() + "\n");
    }

    public void setPlaceBooked(Place place) {
        bookedPlaces.put(place, true);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAmountOfPlaces() {
        return amountOfPlaces;
    }

    public void setAmountOfPlaces(int amountOfPlaces) {
        this.amountOfPlaces = amountOfPlaces;
    }
}

