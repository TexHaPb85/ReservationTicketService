package utilities;

import java.util.Random;

public class DurationOfMovie {
    public String fromTime;
    public String toTime;

    public DurationOfMovie(String fromTime, String toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public DurationOfMovie() {
        Random random = new Random();
        int h = random.nextInt(24);
        int m = random.nextInt(60);
        this.fromTime = h+":"+m;
        this.toTime = (h+2)+":"+m;
    }

    @Override
    public String toString() {
        return "DurationOfMovie{" +
                "fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                '}';
    }
}
