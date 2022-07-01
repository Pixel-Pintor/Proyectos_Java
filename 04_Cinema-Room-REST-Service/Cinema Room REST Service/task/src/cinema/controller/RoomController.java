package cinema.controller;

import cinema.model.RoomModel;
import cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/seats")
    public RoomModel getRoomModel() {
        return roomService.getRoomModel();
    }
}