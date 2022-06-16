package task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/value")
    public ResponseEntity<Integer> getValue() {
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/text")
    public ResponseEntity<String> getText() {
        return new ResponseEntity<>("two", HttpStatus.OK);
    }

    @GetMapping("/json")
    public ResponseEntity<Map<String, Integer>> getJson() {
        return new ResponseEntity<>(Map.of("number", 3), HttpStatus.OK);
    }
}
