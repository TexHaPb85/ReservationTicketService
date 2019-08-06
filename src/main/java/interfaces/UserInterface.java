package interfaces;

import entities.User;

import java.util.Scanner;

public interface UserInterface {

    void registerNewUser(Scanner scanner);

    boolean isRegistered(User user);

    void setAllUsers();
}
