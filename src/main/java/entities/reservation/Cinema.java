package entities.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private double rating;

    private List<Movie> movieList;
    private List<Hall> halls;
    private List<ScheduledMovie> dailyMovieSchedule;

    public Cinema(String name, String address, double rating, List<Movie> movieList, List<Hall> halls) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.movieList = movieList;
        this.halls = halls;
        this.dailyMovieSchedule = new ArrayList<>();

        makeSchedule();
    }

    public List<Movie> addMovie(Movie m) {
        movieList.add(m);
        return this.movieList;
    }

    public List<Hall> addHall(Hall newHall) {
        halls.add(newHall);
        return this.halls;
    }

    /**
     * this method will create random schedule for a week in Cinema
     */
    private void makeSchedule() {
        int hallPointer = 0;
        int plusHours = 0;
        for (int j = 0; j < halls.size(); j++) {
            for (int i = 0; i < movieList.size(); i++) {
                dailyMovieSchedule.add(
                        new ScheduledMovie(LocalDate.now().plusDays(1).atTime(9, 0).plusHours(plusHours),
                                this,
                                halls.get(hallPointer),
                                movieList.get(i)));
                if (hallPointer < halls.size() - 1) {
                    hallPointer++;
                } else {
                    plusHours += 3;
                    hallPointer = 0;
                }
            }
        }
    }


    public String getListOfShowings() {
        StringBuilder sb = new StringBuilder("List of movies in " + name + " cinema: \n");
        sb.append("(press number of movie to book ticket, or '0' to return in main menu)\n");
        sb.append("0. Exit\n");
        for (int i = 0; i < dailyMovieSchedule.size(); i++) {
            sb.append(i + 1).append(". ").append(dailyMovieSchedule.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean containsMovie(Movie movie) {
        return movieList.contains(movie);
    }

    public boolean containsMovie(String movieName) {
        return movieList.stream().anyMatch(m -> m.getName().equalsIgnoreCase(movieName));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }


    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<ScheduledMovie> getDailyMovieSchedule() {
        return dailyMovieSchedule;
    }

    public void setDailyMovieSchedule(List<ScheduledMovie> dailyMovieSchedule) {
        this.dailyMovieSchedule = dailyMovieSchedule;
    }

    @Override
    public String toString() {
        return name + " cinema" +
                "--> address: " + address +
                ", rating: " + rating;
    }
}
