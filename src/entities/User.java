package entities;

import java.util.List;

public class User {
    long userId;
    String name;
    String email;

    public User(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    List<Booking> bookingHistory;

    public List<Booking> viewBookings(){
        return this.bookingHistory;
    }

}
