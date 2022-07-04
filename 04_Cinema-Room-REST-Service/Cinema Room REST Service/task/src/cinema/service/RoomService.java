package cinema.service;

import cinema.model.RoomModel;
import cinema.model.SeatModel;
import cinema.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RoomService {

    RoomModel roomModel;

    @Autowired
    public RoomService(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void updateAvailableSeats(SeatModel seatModelPrice) {
        this.roomModel.getAvailableSeats().remove(seatModelPrice);
    }

    public void updateRoomSeats(SeatModel seatModelPrice) {
        this.roomModel.getRoomSeats().put(seatModelPrice, false);
    }

    public boolean isRowOrColumnOutOfBounds(SeatModel seatModel) {
        return this.roomModel.getRoomSeats().containsKey(seatModel);
    }

    public boolean isSeatAvailable(SeatModel seatModel) {
        return this.roomModel.getRoomSeats().get(seatModel);
    }
}
