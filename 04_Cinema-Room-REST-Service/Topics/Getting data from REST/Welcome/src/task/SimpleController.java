package task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<>("Welcome!", HttpStatus.OK);
    }
}
