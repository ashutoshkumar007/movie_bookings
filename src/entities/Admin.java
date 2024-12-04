package entities;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    long adminId;
    String name;
    String email;

    public Admin(long adminId, String name, String email) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
    }

    private static List<Movie> movieList= new ArrayList<>();
    private static List<Theater> theaterList = new ArrayList<>();

    public void addMovie(Movie movie){
        movieList.add(movie);
        System.out.println("Added new movie :"+movie.getMovieName());
    }

    public void addTheatre(Theater theater){
        theaterList.add(theater);
        System.out.println("New theater added in system. entities.Theater name :"+theater.getName());
    }

    public void addScreenToTheatre(Screen screen, Theater theater){
        theater.addScreen(screen);
    }

    public void addShow(Screen screen, Show show){
        screen.addShow(show);
    }


}
