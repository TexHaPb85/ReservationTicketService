import dao.UserDAO;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        //GlobalCinemaService service = new GlobalCinemaService();
        //service.demo();
        UserDAO ud = new UserService();
        System.out.println(ud.getAllUsers());
    }
}
