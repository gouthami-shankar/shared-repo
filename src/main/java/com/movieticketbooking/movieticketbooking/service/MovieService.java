package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Movie;

public interface MovieService {

  Movie createMovie(Movie movie);

  Movie getMovieDetails(Long movieId);
}
