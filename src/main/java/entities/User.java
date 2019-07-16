package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private List<Booking> bookings;
    private String studentsTiketNumber;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.bookings= new ArrayList<>();
    }

    public User(String login, String password, String studentsTiketNumber) {
        this.login = login;
        this.password = password;
        this.bookings= new ArrayList<>();
        this.studentsTiketNumber = studentsTiketNumber;
    }

    public void addtBookings(Booking booking) {
        this.bookings.add(booking);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "login='" + login + '\'' +
                ", password='" + password + '\'' +
                //", bookings=" + bookings +
                ", studentsTiketNumber='" + studentsTiketNumber+'\'';

    }
}
