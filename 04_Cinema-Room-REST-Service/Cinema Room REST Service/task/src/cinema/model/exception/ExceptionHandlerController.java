package cinema.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    CustomExceptionMessage customExceptionBody;

    @ExceptionHandler(OutOfBoundsException.class)
    public ResponseEntity<CustomExceptionMessage> handleOutOfBounds(OutOfBoundsException e) {
        customExceptionBody = new CustomExceptionMessage(e.getMessage());
        return new ResponseEntity<>(customExceptionBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeatBookedException.class)
    public ResponseEntity<CustomExceptionMessage> handleSeatBooked(SeatBookedException e) {
        customExceptionBody = new CustomExceptionMessage(e.getMessage());
        return new ResponseEntity<>(customExceptionBody, HttpStatus.BAD_REQUEST);
    }
}
