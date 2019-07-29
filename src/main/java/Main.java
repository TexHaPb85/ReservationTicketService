import services.GlobalCinemaService;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GlobalCinemaService service = new GlobalCinemaService();
        service.start();
/*        User user = new User("u2", "p1", "-");
        UserService service = new UserService();
        service.registerUser(user);
        File file = new File("C:\\Java20182019\\ReservationTicketService\\src\\main\\resources\\users.txt");
        System.out.println(FileWorker.readFile(file));*/
        Map<String,Boolean> bookedPlaces = new LinkedHashMap<>();
        bookedPlaces.forEach((place,isBooked)->isBooked=false);

    }
}
