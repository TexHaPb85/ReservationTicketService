package enums;

public enum TypeOfMovie {
    ORIGINAL("original language film"),
    TRANSLATED("translated film");

    private String val;

    TypeOfMovie(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
