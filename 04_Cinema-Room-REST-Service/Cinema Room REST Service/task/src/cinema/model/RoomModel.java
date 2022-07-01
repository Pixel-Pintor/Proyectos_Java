package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RoomModel {
    private final int totalRows;
    private final int totalColumns;
    private final List<SeatModelPrice> availableSeats = new ArrayList<>(); // sillas con precio
    @JsonIgnore
    private final Map<SeatModelPrice, Boolean> roomSeats = new HashMap<>(); // sillas con precio y disponibilidad

    @Autowired
    public RoomModel() {
        this.totalRows = 9;
        this.totalColumns = 9;
        this.createAvailableSeats();
    }

    public void createCinemaRoomSeats() {
        for (int i = 1; i <= this.totalRows; i++) {
            for (int j = 1; j <= this.totalColumns; j++) {
                this.getAvailableSeats().add(new SeatModelPrice(i, j));
            }
        }
    }

    public void createAvailableSeats() {
        this.createCinemaRoomSeats();
        for (SeatModelPrice seat : this.getAvailableSeats()) {
            this.getRoomSeats().put(seat, true);
        }
    }

    @SuppressWarnings("unused")
    @JsonProperty("total_rows")
    public int getTotalRows() {
        return totalRows;
    }

    @SuppressWarnings("unused")
    @JsonProperty("total_columns")
    public int getTotalColumns() {
        return totalColumns;
    }

    @JsonProperty("available_seats")
    public List<SeatModelPrice> getAvailableSeats() {
        return availableSeats;
    }

    public Map<SeatModelPrice, Boolean> getRoomSeats() {
        return roomSeats;
    }

    @Override
    public String toString() {
        StringBuilder roomModelAsString = new StringBuilder("[");
        for (SeatModelPrice seatModel : this.availableSeats) {
            roomModelAsString.append(seatModel.toString()).append(", ");
        }
        roomModelAsString.append("]");
        return roomModelAsString.toString();
    }
}
