package entities;

import enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final String bookingId;
    private final User user;
    private float price;
    private final Show show;
    private final List<Seat> seats;
    private final LocalDateTime bookingTime;
    private BookingStatus status;

    public Booking(User user, Show show, List<Seat> seat, String bookingId){
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seat;
        bookingTime = LocalDateTime.now();
        this.price = show.calculatePrice(seat);
        this.status = BookingStatus.PENDING;

    }

    public float getPrice() {
        return price;
    }

    public void confirmBooking(){
        this.status= BookingStatus.CONFIRM;
        seats.forEach(show::bookSeat);
    }

    public void cancelBooking(){
        this.status=BookingStatus.CANCELLED;
        seats.forEach(show::releaseSeat);
    }

    private float calculateBookingPrice(Show show, List<Seat> seat) {
        return seat.size() * 150;
    }

}
