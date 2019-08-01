package entities;

import entities.reservation.Booking;
import utilities.CreditCardChecker;

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

    public void showBookingList(Scanner scanner) {
        StringBuilder sb = new StringBuilder(login + "`s, booking list:\n");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            sb.append((i+1)+". ")
                    .append(booking.getMovieShowing().getShowingMovie().getName() + ": ")
                    .append(booking.getMovieShowing().getShowingDate() + ", ");
            if (booking.isPaid()) {
                sb.append(" is paid ");
            } else {
                sb.append(" not paid ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        if(!bookings.isEmpty()){
            System.out.println("Enter number of booking to see more information about that booking. Enter -1, to go to the main menu.");
            int indexOfBooking = scanner.nextInt();
            System.out.println(bookings.get(indexOfBooking-1).toString());
        }else {
            System.out.println("You have no bookings yet");
        }
    }

    public void payUnpaidBookings(Scanner scanner){
        System.out.println("Enter number of unpaid booking:");
        showBookingList(scanner);
        int indexOfBookingToPay = scanner.nextInt();
        System.out.println("Please enter info of your credit card to make a payment, or enter '-', if you want to pay it later");
        System.out.println("format of info: 5355-7632-2131-2501_08:12_243");
        String creditCardInfo = scanner.next();
        if(CreditCardChecker.isCorrectCardInfo(creditCardInfo)){
            bookings.get(indexOfBookingToPay-1).setPaid(true);
        }
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
