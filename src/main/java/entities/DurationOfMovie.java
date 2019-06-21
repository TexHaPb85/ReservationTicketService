package entities;

public class DurationOfMovie {
    public String fromTime;
    public String toTime;

    public DurationOfMovie(String fromTime, String toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    @Override
    public String toString() {
        return "DurationOfMovie{" +
                "fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                '}';
    }
}
