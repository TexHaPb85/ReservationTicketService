import entities.Cinema;
import entities.Movie;
import services.SelectCinemaService;

import java.util.List;

public class GlobalCinemaService {
    private SelectCinemaService service;
    private List<Cinema> availableCinemas;
    private List<Movie> movies;

}
