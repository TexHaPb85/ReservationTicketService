package dao;

import entities.User;

import java.util.List;

public interface UserDAO {

    void registerUser(User user);

    boolean isRegistered(User user);

    void setAllUsers();
}
