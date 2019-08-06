package enums;

public enum TypeOfPlace {
    NORMAL("N"),
    PREMIUM("P"),
    VIP("V");

    private String sigh;

    TypeOfPlace(String sigh) {
        this.sigh = sigh;
    }

    public String getSigh() {
        return sigh;
    }
}
