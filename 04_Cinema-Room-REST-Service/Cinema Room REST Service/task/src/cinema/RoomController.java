package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final Room cinemaRoom = new Room();

    @GetMapping("/seats")
    public ResponseEntity<Room> getSeats() {
        return new ResponseEntity<>(cinemaRoom, HttpStatus.OK);
    }
}