package com.movieticketbooking.movieticketbooking.controller;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.dto.Ticket;
import com.movieticketbooking.movieticketbooking.service.MovieService;
import com.movieticketbooking.movieticketbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater/movie")
public class MovieTicketController {

  @Autowired
  private MovieService movieService;

  @Autowired
  private TicketService ticketService;

  @PostMapping
  ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
    return new ResponseEntity<Movie>(movieService.createMovie(movie), HttpStatus.CREATED);
  }

  @PostMapping("/ticket/booking")
  ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket, Long movieId) {
    return new ResponseEntity<Ticket>(ticketService.createTicket(ticket, movieId), HttpStatus.CREATED);
  }

  @GetMapping("/{movieId}")
  ResponseEntity<Movie> getMovieById(@PathVariable("movieId") Long movieId) {
    return new ResponseEntity<>(movieService.getMovieDetails(movieId), HttpStatus.OK);
  }
}
