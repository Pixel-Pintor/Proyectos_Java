package com.jetbrains.sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

// RoomModel.java
public class SeatArrangement {
    final private int ROWS = 9;
    final private int COLUMNS = 9;
    final private int TOTAL_SEATS = ROWS * COLUMNS;
    private Seat[] seats;

    public SeatArrangement() {
        this.seats = new Seat[TOTAL_SEATS];
        for (int x = 0; x < ROWS; x++){
            for (int y = 0; y < COLUMNS; y++){
                this.seats[COLUMNS * y + x] = new Seat(x + 1, y + 1);
            }
        }
    }

    @Override
    public String toString() {
        return "seatArrangement{" +
                "ROWS=" + ROWS +
                ", COLUMNS=" + COLUMNS +
                ", seats=" + Arrays.toString(seats) +
                '}';
    }

    public Map getSeatArrangement(){
        return Map.of("total_rows", ROWS, "total_columns", COLUMNS, "seats", seats);
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public int getTOTAL_SEATS() {
        return TOTAL_SEATS;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public Map getAvailableSeats() {
        HashSet<Seat> availableSeats = new HashSet<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return Map.of("total_rows", ROWS, "total_columns", COLUMNS, "available_seats", availableSeats);
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public Seat getSeatByPosition(int row, int column) {

        return this.seats[(COLUMNS * (column -1) + (row -1))];
    }
}