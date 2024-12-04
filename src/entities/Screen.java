package entities;

import enums.SeatStatus;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenId;
    private String screenName;
    private List<Seat> seatList;
    private List<Show> showList;

    public Screen(int screenId, String name, List<Seat> seatList) {
        this.screenId = screenId;
        this.screenName = name;
        this.seatList = seatList;
        showList = new ArrayList<>();
    }

    public String getScreenName() {
        return screenName;
    }

    public void addShow(Show show){
        seatList.forEach(seat -> show.getSeatAvailable().put(seat.getSeatId(), SeatStatus.AVAILABLE));
        showList.add(show);
    }

}
