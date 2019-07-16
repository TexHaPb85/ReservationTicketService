package entities;

import Enums.TypeOfPlace;

public class Place {
    private int row;
    private int placeNum;
    private TypeOfPlace type;

    public Place(int row, int placeNum, TypeOfPlace type) {
        this.row = row;
        this.placeNum = placeNum;
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(int placeNum) {
        this.placeNum = placeNum;
    }

    public TypeOfPlace getType() {
        return type;
    }

    public void setType(TypeOfPlace type) {
        this.type = type;
    }
}
