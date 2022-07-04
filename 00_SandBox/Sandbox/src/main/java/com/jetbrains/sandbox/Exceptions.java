package com.jetbrains.sandbox;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class Exceptions {
    @ExceptionHandler(SeatOutOfBoundsException.class)
    public ResponseEntity<Map<String, String>> seatOutOfBoundsException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "The number of a row or a column is out of bounds!"));
    }

    @ExceptionHandler(SeatAlreadySoldException.class)
    public ResponseEntity<Map<String, String>> seatAlreadySoldException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "The ticket has been already purchased!"));
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<Map<String, String>> tokenNotFoundException(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Wrong token!"));
    }
}
