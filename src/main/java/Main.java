import entities.Cinema;
import services.SelectCinemaService;

public class Main {
    public static void main(String[] args) {
        SelectCinemaService cinemaShower = new SelectCinemaService();
        for (int i = 0; i < 15; i++) {
            cinemaShower.addCinema(new Cinema());
        }
        cinemaShower.showListOfCinemas();
        cinemaShower.showListOfFilmsInSelectedCinema(5);
    }
}
