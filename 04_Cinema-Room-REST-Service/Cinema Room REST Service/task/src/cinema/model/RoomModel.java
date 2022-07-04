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
    private final List<SeatModel> availableSeats = new ArrayList<>(); // sillas con precio
    @JsonIgnore
    private final Map<SeatModel, Boolean> roomSeats = new HashMap<>(); // sillas con precio y disponibilidad
    @JsonIgnore
    private final List<TokenModel> tokensList = new ArrayList<>();

    @Autowired
    public RoomModel() {
        this.totalRows = 9;
        this.totalColumns = 9;
        this.createAvailableSeats();
    }

    public void createCinemaRoomSeats() {
        for (int i = 1; i <= this.totalRows; i++) {
            for (int j = 1; j <= this.totalColumns; j++) {
                this.getAvailableSeats().add(new SeatModel(i, j, true));
            }
        }
    }

    public void createAvailableSeats() {
        this.createCinemaRoomSeats();
        for (SeatModel seat : this.getAvailableSeats()) {
            this.getRoomSeats().put(seat, true);
        }
    }

    public List<TokenModel> getTokensList() {
        return tokensList;
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
    public List<SeatModel> getAvailableSeats() {
        return availableSeats;
    }

    public Map<SeatModel, Boolean> getRoomSeats() {
        return roomSeats;
    }

    @Override
    public String toString() {
        StringBuilder roomModelAsString = new StringBuilder("[");
        for (SeatModel seatModel : this.availableSeats) {
            roomModelAsString.append(seatModel.toString()).append(", ");
        }
        roomModelAsString.append("]");
        return roomModelAsString.toString();
    }
}
