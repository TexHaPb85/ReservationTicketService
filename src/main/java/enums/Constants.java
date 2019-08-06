package enums;

public enum Constants {
    MIN_PART_OF_MOVIE(1),
    MAX_PART_OF_MOVIE(9);

    private int val;

    Constants(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
