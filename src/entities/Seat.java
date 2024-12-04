package entities;

import enums.SeatType;

public class Seat {
    private final int seatId;
    private final String rowNum;
    private final int colNum;
    private SeatType type;

    public Seat(int seatId, String rowNum, int colNum, SeatType type) {
        this.seatId = seatId;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.type = type;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }
}
