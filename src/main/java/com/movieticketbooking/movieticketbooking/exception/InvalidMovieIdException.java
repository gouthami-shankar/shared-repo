package com.movieticketbooking.movieticketbooking.exception;

public class InvalidMovieIdException extends RuntimeException{

  public InvalidMovieIdException(String message) {
    super(message);
  }
}
