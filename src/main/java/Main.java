import dao.UserDAO;
import entities.User;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        //GlobalCinemaService service = new GlobalCinemaService();
        //service.demo();
        UserService ud = new UserService();
        //ud.addUser(new User("Michael", "12m31","KV325094"));
        System.out.println(ud.getUsers());
    }
}
