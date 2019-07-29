package Enums;

public enum TypeOfPlace {
    normal("N"),
    premium("P"),
    VIP("V");

    private String sigh;

    TypeOfPlace(String sigh) {
        this.sigh = sigh;
    }

    public String getSigh() {
        return sigh;
    }
}
