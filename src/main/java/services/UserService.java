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
        this.usersFile = new File(getClass().getClassLoader().getResource("users.txt").getFile());
        setAllUsers();
    }

    @Override
    public void addUser(User user) {
        String userInfo = "\n"+user.getLogin()+" "+user.getPassword()+" "+user.getStudentsTiketNumber();
        FileWorker.writeToFile(usersFile,userInfo);
    }

    @Override
    public boolean isRegistered(User user) {
        return users.contains(user);
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
                if(user.length==3){
                    users.add(new User(user[0], user[1], user[2]));
                }else if(user.length==2){
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
