package cinema.controller;

import cinema.model.SeatModel;
import cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody SeatModel seatModel) {
        return seatService.managePurchaseSeatRequest(seatModel);
    }
}
