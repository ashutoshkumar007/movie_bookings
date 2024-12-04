package services;

import entities.*;
import enums.SeatType;
import services.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin(1, "John Doe", "john.doe@example.com");
        User user = new User(1, "John Doe", "john.doe@example.com");
        Address address = new Address("Telangana", "Hyderabad", "Kondapur","Sarath",500084);
        Movie movie = new Movie(101, "Inception", "Sci-Fi");

        List<Seat> seats = createListOfSeats();
        Screen screen = new Screen(1,"Satyam",seats);
        Theater theater = new Theater(201, "PVR Cinemas", address);
        Show show = new Show(301, movie, LocalDateTime.of(2024, 12, 5, 18, 0), LocalDateTime.of(2024, 12, 5, 20, 30));
        admin.addTheatre(theater);
        admin.addScreenToTheatre(screen,theater);
        admin.addMovie(movie);
        admin.addShow(screen,show);

        BookingService bookingService = new BookingService();
        bookingService.bookTickets(user,show,seats);
        bookingService.bookTickets(user,show,seats);


    }

    private static List<Seat> createListOfSeats() {
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(1,"A",1, SeatType.PREMIUM));
        seats.add(new Seat(2,"A",2,SeatType.PREMIUM));
        seats.add(new Seat(3,"B",1,SeatType.ECONOMY));
        seats.add(new Seat(4,"B",2,SeatType.ECONOMY));
        return seats;
    }
}