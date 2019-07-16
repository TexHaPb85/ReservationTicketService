package services;

import dao.UserDAO;
import entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements UserDAO {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public boolean isRegistered(User user) {


        return false;
    }

    @Override
    public List<User> getAllUsers() {
        File file = new File(getClass().getClassLoader().getResource("users.txt").getFile());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNextLine()) {
                String[] user = sc.nextLine().split("[ ]");
                try {
                    users.add(new User(user[0],user[1],user[2]));
                }catch (ArrayIndexOutOfBoundsException e){
                    users.add(new User(user[0],user[1]));
                }

            }
        }
        return users;
    }

}
