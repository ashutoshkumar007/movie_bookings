package services;

import entities.*;

import java.util.List;

public class BookingService {

    public void bookTickets(User user, Show show, List<Seat> seats){
        System.out.println("entities.Booking started for movie :"+ show.getMovie().getMovieName());
        if(!lockSeats(show,seats)){
            System.out.println("entities.Booking failed, seats are not available. Please book other seats");
            return;
        }
        Booking booking = new Booking(user,show,seats,generateBookingId());
        Payment payment = new Payment(generatePaymentId(), booking.getPrice());
        boolean paymentSuccess = payment.processPayment();
        if(paymentSuccess){
            booking.confirmBooking();
            System.out.println("entities.Booking created for movie "+show.getMovie().getMovieName());
            System.out.println("entities.Show time "+show.getStartTime());
            System.out.print("Your seats :");
            seats.forEach(seat -> System.out.print(seat.getRowNum()+""+seat.getColNum()+","));
            System.out.println("");
        }else{
            booking.cancelBooking();
            System.out.println("entities.Booking cancelled due to payment failure");
        }
    }
    private boolean lockSeats(Show show, List<Seat> seats) {
        if(!areSeatsAvailable(show,seats))
            return false;
        seats.forEach(seat -> show.lockSeat(seat));
        return true;
    }

    private boolean areSeatsAvailable(Show show, List<Seat> seats) {
        for(Seat seat : seats){
            if(!show.isSeatAvailable(seat))
                return false;
        }
        return true;
    }

    private String generateBookingId() {
        return "book"+System.currentTimeMillis();
    }

    private String generatePaymentId() {
        return "pay"+System.currentTimeMillis();
    }
}
