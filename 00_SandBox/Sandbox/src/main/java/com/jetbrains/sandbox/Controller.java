package com.jetbrains.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private SeatArrangement seatArrangement;
    @Autowired
    private Tokens tokens;

    @GetMapping("/seats")
    public Map getAvailableSeats() {
        return seatArrangement.getAvailableSeats();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody Seat tempSeat) {

        if (tempSeat.getRow() > seatArrangement.getROWS() || tempSeat.getRow() < 1 ||
                tempSeat.getColumn() > seatArrangement.getCOLUMNS() || tempSeat.getColumn() < 1) {
            throw new SeatOutOfBoundsException();
        }

        Seat seat = seatArrangement.getSeatByPosition(tempSeat.getRow(), tempSeat.getColumn());

        if (!seat.isAvailable()) {
            throw new SeatAlreadySoldException();
        }
        seat.setAvailable(false);
        String token = tokens.addToken(seat);

        Map<String, Object> returnBody = Map.of("token", token, "ticket", seat);
        return ResponseEntity.status(HttpStatus.OK).body(returnBody);
    }

    @PostMapping("/return")
    public Map<String, Seat> returnTicket(@RequestBody Map<String, String> returnToken) {
        try {
            Seat seat = tokens.getSeatByToken(returnToken.get("token"));
            seat.setAvailable(true);
            tokens.removeToken(returnToken.get("token"));
            return Map.of("returned_ticket", seat);

        }
        catch (NullPointerException e) {
            throw new TokenNotFoundException();
        }
    }

    @GetMapping("/get_all_tokens")
    public Map getAllTokens() {return tokens.getTokenMap();}
}