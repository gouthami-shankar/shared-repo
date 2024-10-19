package com.movieticketbooking.movieticketbooking.controller;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater/movie")
public class MovieTicketController {

  @Autowired
  private MovieService movieService;

  @PostMapping
  ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
    return new ResponseEntity<Movie>(movieService.createMovie(movie), HttpStatus.CREATED);
  }
}
