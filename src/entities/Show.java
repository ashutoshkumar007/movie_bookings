package entities;

import enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    private int showId;
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<Integer , SeatStatus> seatAvailable;

    public Show(int showId, Movie movie, LocalDateTime startTime, LocalDateTime endTime) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        seatAvailable = new HashMap<>();
    }

    public Movie getMovie() {
        return movie;
    }

    public Map<Integer, SeatStatus> getSeatAvailable() {
        return seatAvailable;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isSeatAvailable(Seat seat){
        return seatAvailable.get(seat.getSeatId()) == SeatStatus.AVAILABLE;
    }

    public void lockSeat(Seat seat){
        seatAvailable.put(seat.getSeatId(), SeatStatus.LOCKED);
    }

    public void bookSeat(Seat seat){
        seatAvailable.put(seat.getSeatId(),SeatStatus.BOOKED);
    }

    public void releaseSeat(Seat seat){
         seatAvailable.put(seat.getSeatId(), SeatStatus.AVAILABLE);
    }

    public float calculatePrice(List<Seat> seats){
        return seats.size() * 150;
    }
}
