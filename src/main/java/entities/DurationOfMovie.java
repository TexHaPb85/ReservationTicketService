package entities;

import abstractions.RandomGenerator;
import services.RandomGeneratorService;

public class DurationOfMovie {
    public String fromTime;
    public String toTime;

    public DurationOfMovie(String fromTime, String toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public DurationOfMovie() {
        RandomGenerator rg = new RandomGeneratorService();
        int h = rg.intRandom(0,24);
        int m = rg.intRandom(0,60);
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
