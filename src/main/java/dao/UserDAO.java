package dao;

import entities.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    boolean isRegistered(User user);

    List<User> getAllUsers();
}
