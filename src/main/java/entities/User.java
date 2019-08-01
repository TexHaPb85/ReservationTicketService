package entities;

import entities.reservation.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Client {
    private String login;
    private String password;
    private List<Booking> bookings;
    private String studentsTicketNumber;

    public User() {
        this.login = "unknown";
        this.password = "";
        this.bookings = new ArrayList<>();
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public User(String login, String password, String studentsTiketNumber) {
        if (studentsTiketNumber.toUpperCase().contains("KV")) {
            this.studentsTicketNumber = studentsTiketNumber;
        }
        this.login = login;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public void setAditionalInfo(Scanner scanner) {
        System.out.println("Enter your name");
        String name = scanner.next();
        setName(name);
        System.out.println("Enter your surname");
        String surname = scanner.next();
        setSurname(surname);
        System.out.println("Enter your age");
        int age = scanner.nextInt();
        setAge(age);
        System.out.println("Enter your email");
        String email = scanner.next();
        setEmail(email);
        System.out.println("Enter your phone");
        String phone = scanner.next();
        setPhone(phone);
    }

    public void addBookings(Booking booking) {
        this.bookings.add(booking);
    }

    public boolean isAbleToBook() {
        return bookings.stream()
                .filter(booking -> !booking.isPaid())
                .count() <= 2;
    }

    public boolean isAuthorized() {
        return !login.equalsIgnoreCase("unknown")
                && !password.equalsIgnoreCase("");
    }

    public void showBookingList() {
        StringBuilder sb = new StringBuilder(login + "`s, booking list:\n");
        bookings.forEach(booking -> {
            sb.append(booking.getMovieShowing().getShowingMovie().getName() + ": ")
                    .append(booking.getMovieShowing().getShowingDate() + ", ");
            if (booking.isPaid()) {
                sb.append(" is paid ");
            } else {
                sb.append(" not paid ");
            }
            sb.append("\n");
        });
        System.out.println(sb.toString());
    }

    public boolean isStudent(){
        return studentsTicketNumber.toUpperCase().contains("KV") && studentsTicketNumber.length()>6;
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

    public String getStudentsTicketNumber() {
        return studentsTicketNumber;
    }

    public void setStudentsTicketNumber(String studentsTicketNumber) {
        this.studentsTicketNumber = studentsTicketNumber;
    }

    @Override
    public String toString() {
        return "\nlogin='" + login + '\'' +
                ", password='" + password + '\'' +
                //", bookings=" + bookings +
                ", studentsTicketNumber='" + studentsTicketNumber + "\'";

    }
}
