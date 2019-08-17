package utilities;

public class Rand {
    public static int intRandom(int from, int to) {
        return (int) (from + Math.random() * (to - from));
    }

    public static double getRandomDouble(double min, double max) {
        return min + Math.random() * (max - min);
    }
}
