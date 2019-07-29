package entities.reservation;

import Enums.TypeOfPlace;

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

