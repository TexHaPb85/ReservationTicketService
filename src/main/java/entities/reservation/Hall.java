package entities.reservation;

import Enums.TypeOfPlace;

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
        Place bookingPlace = new Place();
        for (Place place : bookedPlaces.keySet()) {
            if (place.getPlaceNumber() == number) {
                bookedPlaces.put(place, true);
                bookingPlace=place;
            }
        }
        return bookingPlace;
    }

    private void fillBookedPlacesList(BigDecimal normalTicketPrice) {
        for (int i = 1; i <= amountOfPlaces; i++) {
            if (i < amountOfPlaces / 8) {
                BigDecimal priceOfTicket = normalTicketPrice.multiply(BigDecimal.valueOf(1.5));
                Place place = new Place(i, TypeOfPlace.VIP, priceOfTicket);
                bookedPlaces.put(place, false);
            } else if (i < amountOfPlaces / 2) {
                BigDecimal priceOfTicket = normalTicketPrice.multiply(BigDecimal.valueOf(1.2));
                Place place = new Place(i, TypeOfPlace.premium, priceOfTicket);
                bookedPlaces.put(place, false);
            } else {
                Place place = new Place(i, TypeOfPlace.normal, normalTicketPrice);
                bookedPlaces.put(place, false);
            }
        }
    }

    public void showBookedPlaces() {
        StringBuilder sb = new StringBuilder("Hall: " + number + "\n");
        int numOfPlacesInOneRow = (int) Math.sqrt(amountOfPlaces);
        bookedPlaces.forEach((place, isBooked) -> {
            if (!isBooked) {
                sb.append(place.getType().getSigh() + place.getPlaceNumber() + " ");
            } else {
                sb.append(place.getType().getSigh() + place.getPlaceNumber() + "# ");
            }
            if ((place.getPlaceNumber() + 1) % numOfPlacesInOneRow == 0) {
                sb.append("\n");
            }
        });
        System.out.println(sb.toString());
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

