package entities;

import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private double rating;
    private List<Movie> movieList;

    public Cinema(String name, String address, double rating, List<Movie> movieList) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.movieList = movieList;
    }

    public Cinema() {
    }

    public List<Movie> addMovie(Movie m){
        movieList.add(m);
        return this.movieList;
    }

    public String getListOfMovies(){
        StringBuilder sb = new StringBuilder("List of movies in " + name +" cinema: \n");
        movieList.stream().forEach(m->{
            sb.append(m.toString()).append("\n");
        });
        return sb.toString();
    }

    public boolean containsMovie(Movie movie){
        return movieList.contains(movie);
    }

    public boolean containsMovie(String movieName){
        return movieList.stream().filter(m->m.getName().equals(movieName)).count()>0;
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



    @Override
    public String toString() {
        return  name + " cinema" +
                "--> address: " + address +
                ", rating: " + rating;
    }
}
