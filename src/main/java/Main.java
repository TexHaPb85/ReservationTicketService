import services.GlobalCinemaService;

public class Main {
    public static void main(String[] args) {
        GlobalCinemaService service = new GlobalCinemaService();
        service.start();
    }
}


/**
 * Functionalities:
 1.  Added the possibility to select cinema and see a list of all the movies +
 2.  Implement basic searching facilities based on various factors (category, rating) +
 3.  Added the possibility to select multiple the AVAILABLE places with a choice of place type +
 4.  If the client has more than 2 unpaid bookings, he can not book a ticket until he has paid the previous one. -+
 5   Implement a discount system after the PREMIERE period( for students : -10%, after PREMIERE: -15%, on day of movies: -7%  )
 6.  Сlient must be able to view all his bookings with information about the movie, the number of tickets, the total amount,
     and the time until the end of the booking ( the last date on which he must pay the reservation )
 */
