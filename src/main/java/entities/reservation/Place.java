package entities.reservation;

import enums.StatusOfMovie;
import enums.TypeOfPlace;
import entities.User;

import java.math.BigDecimal;

public class Place {
    private int placeNumber;
    private TypeOfPlace type;
    private BigDecimal price;

    public Place(int placeNumber, TypeOfPlace type, BigDecimal price) {
        this.placeNumber = placeNumber;
        this.type = type;
        this.price = price;
    }

    public Place() {
        this.placeNumber = -1;
        this.type = TypeOfPlace.NORMAL;
        this.price = new BigDecimal(0);
    }

    public void setDiscountPrice(ScheduledMovie scheduledMovie, User user) {
        if (scheduledMovie.getShowingMovie().getStatus().equals(StatusOfMovie.AVAILABLE)) {
            price = price.multiply(BigDecimal.valueOf(0.85));
        }
        if (user.isStudent()) {
            price = price.multiply(BigDecimal.valueOf(0.9));
        }
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public TypeOfPlace getType() {
        return type;
    }

    public void setType(TypeOfPlace type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

