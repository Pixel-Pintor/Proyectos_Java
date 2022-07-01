package cinema.service;

import cinema.model.SeatModel;
import cinema.model.SeatModelPrice;
import cinema.model.exception.OutOfBoundsException;
import cinema.model.exception.SeatBookedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeatService {

    RoomService roomService;

    @Autowired
    public SeatService(RoomService roomService) {
        this.roomService = roomService;
    }

    public SeatModelPrice managePurchaseSeatRequest(SeatModel seatModel) {
        SeatModelPrice seatModelPrice = new SeatModelPrice(seatModel);
        if (!roomService.isRowOrColumnOutOfBounds(seatModelPrice)) {
            throw new OutOfBoundsException();
        } else if (!roomService.isSeatAvailable(seatModelPrice)) {
            throw new SeatBookedException();
        } else {
            roomService.updateRoomSeats(seatModelPrice);
            roomService.updateAvailableSeats(seatModelPrice);
        }
        return seatModelPrice;
    }
}
