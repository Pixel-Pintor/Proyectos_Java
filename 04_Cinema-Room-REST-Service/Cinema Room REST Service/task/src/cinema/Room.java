package cinema;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.ArrayList;



public class Room {
    final int NINE = 9;
    int totalRows = NINE;
    int totalColumns = NINE;
    ArrayList<Seat> roomSeats = new ArrayList<>();

    public Room() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                roomSeats.add(new Seat(i, j));
            }
        }
    }

    @JsonGetter(value = "total_rows")
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    @JsonGetter(value = "total_columns")
    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    @JsonGetter(value = "available_seats")
    public ArrayList<Seat> getRoomSeats() {
        return roomSeats;
    }

    public void setRoomSeats(ArrayList<Seat> roomSeats) {
        this.roomSeats = roomSeats;
    }
}
