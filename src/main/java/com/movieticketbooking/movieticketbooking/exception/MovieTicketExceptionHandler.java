package com.movieticketbooking.movieticketbooking.exception;

import com.movieticketbooking.movieticketbooking.controller.MovieTicketController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(assignableTypes = MovieTicketController.class)
public class MovieTicketExceptionHandler {

  @ExceptionHandler(InvalidMovieIdException.class)
  public ResponseEntity<Map<String, Object>> exception(InvalidMovieIdException exception) {
    Map<String, Object> response = new HashMap<String, Object>();
    response.put("Error", true);
    response.put("Error Message", exception.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidTicketIdException.class)
  public ResponseEntity<Map<String, Object>> exception(InvalidTicketIdException exception) {
    java.util.Map<String, Object> response = new HashMap<String, Object>();
    response.put("Error", true);
    response.put("Error Message", exception.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InputMisMatchException.class)
  public ResponseEntity<Map<String, Object>> exception(InputMisMatchException exception) {
    java.util.Map<String, Object> response = new HashMap<String, Object>();
    response.put("Error", true);
    response.put("Error Message", exception.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
