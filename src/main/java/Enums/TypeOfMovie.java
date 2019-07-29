package Enums;

public enum TypeOfMovie {
    Original("original language film"),
    Translated("translated film");

    private String val;

    TypeOfMovie(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
