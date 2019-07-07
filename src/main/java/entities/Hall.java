package entities;

import Enums.TypeOfPlace;

public class Hall {
    private String number;
    private int amountOfPlaces;
    private TypeOfPlace typeOfPlace;  //type of place(normal, premium, vip),


    public Hall(String number, int amountOfPlaces, TypeOfPlace typeOfPlace) {
        this.number = number;
        this.amountOfPlaces = amountOfPlaces;
        this.typeOfPlace = typeOfPlace;
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

    public TypeOfPlace getTypeOfPlace() {
        return typeOfPlace;
    }

    public void setTypeOfPlace(TypeOfPlace typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
    }
}

