package dao;

import entities.User;

import java.util.List;
import java.util.Scanner;

public interface UserDAO {

    void registerNewUser(Scanner scanner);

    boolean isRegistered(User user);

    void setAllUsers();
}
