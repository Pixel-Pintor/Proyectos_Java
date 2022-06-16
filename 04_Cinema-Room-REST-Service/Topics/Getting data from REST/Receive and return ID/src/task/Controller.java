package task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping("/{id}")
    public ResponseEntity<String> getInputID(@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
