package entities;

public class Movie {
    int movieId;
    private String movieName;
    private String genre;
    private String details;
    private int duration;
    private String language;

    public Movie(int movieId, String movieName, String genre) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDetails() {
        return details;
    }
}
