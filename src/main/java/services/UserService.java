package services;

import dao.UserDAO;
import entities.User;
import utilities.FileWorker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements UserDAO {
    private List<User> users;
    private File usersFile;

    public UserService() {
        this.users = new ArrayList<>();
        this.usersFile = new File("C:\\Java20182019\\ReservationTicketService\\src\\main\\resources\\users.txt");
        //this.usersFile = new File(getClass().getClassLoader().getResource("users.txt").getFile());
        setAllUsers();
    }

    public void logIn(Scanner sc) {
        System.out.println("Enter your login:");
        String login = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();

        User loginUser = new User(login, password);
        //System.out.println(isRegistered(loginUser));
        users.stream()
                .filter(user -> user.getLogin().equalsIgnoreCase(loginUser.getLogin())
                             && user.getPassword().equals(loginUser.getPassword()))
                .findFirst()
                .ifPresent(user -> GlobalCinemaService.currentUser = user);
    }

    @Override
    public void registerUser(User user) {
        String userInfo = "\n" + user.getLogin() + " " + user.getPassword() + " " + user.getStudentsTicketNumber();
        FileWorker.writeToFile(usersFile, userInfo);
        setAllUsers();
    }

    @Override
    public boolean isRegistered(User inputUser) {
        return users.stream()
                .anyMatch(user -> user.getLogin().equalsIgnoreCase(inputUser.getLogin())
                               && user.getPassword().equalsIgnoreCase(inputUser.getPassword()));
    }

    @Override
    public void setAllUsers() {
        this.users = new ArrayList<>();
        Scanner sc = null;

        try {
            sc = new Scanner(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNextLine()) {
                String[] user = sc.nextLine().split("[ ]");
                if (user.length == 3) {
                    users.add(new User(user[0], user[1], user[2]));
                } else if (user.length == 2) {
                    users.add(new User(user[0], user[1]));
                }
            }
        }
    }

    public List<User> getUsers() {
        setAllUsers();
        return users;
    }
}
