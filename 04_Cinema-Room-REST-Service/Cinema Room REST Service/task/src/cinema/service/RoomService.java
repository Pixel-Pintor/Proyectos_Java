package cinema.service;

import cinema.model.RoomModel;
import cinema.model.SeatModel;
import cinema.model.SeatModelPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RoomService {

    RoomModel roomModel;

    @Autowired
    public RoomService(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void updateAvailableSeats(SeatModelPrice seatModelPrice) {
        this.roomModel.getAvailableSeats().remove(seatModelPrice);
    }

    public void updateRoomSeats(SeatModelPrice seatModelPrice) {
        this.roomModel.getRoomSeats().put(seatModelPrice, false);
    }

    public boolean isRowOrColumnOutOfBounds(SeatModelPrice seatModelPrice) {
        return this.roomModel.getRoomSeats().containsKey(seatModelPrice);
    }

    public boolean isSeatAvailable(SeatModelPrice seatModelPrice) {
        return this.roomModel.getRoomSeats().get(seatModelPrice);
    }
}
