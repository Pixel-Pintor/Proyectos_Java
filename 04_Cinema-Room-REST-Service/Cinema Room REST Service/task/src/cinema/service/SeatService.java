package cinema.service;

import cinema.model.SeatModel;
import cinema.model.TokenListModel;
import cinema.model.exception.OutOfBoundsException;
import cinema.model.exception.SeatBookedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SeatService {

    RoomService roomService;
    TokenListModel tokenListModel;

    @Autowired
    public SeatService(RoomService roomService) {
        this.roomService = roomService;
    }

    public ResponseEntity<?> managePurchaseSeatRequest(SeatModel seatModel) {
        if (!roomService.isRowOrColumnOutOfBounds(seatModel)) {
            throw new OutOfBoundsException();
        } else if (!roomService.isSeatAvailable(seatModel)) {
            throw new SeatBookedException();
        } else {
            roomService.updateRoomSeats(seatModel);
            roomService.updateAvailableSeats(seatModel);
            // crear el token para esta silla
            String token = tokenListModel.addToken(seatModel);
            Map<String, Object> returnBody = Map.of("token", token, "ticket", seatModel);
            return ResponseEntity.status(HttpStatus.OK).body(returnBody);
        }
    }
}
