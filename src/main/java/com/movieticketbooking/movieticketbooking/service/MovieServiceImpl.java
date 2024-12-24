package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import com.movieticketbooking.movieticketbooking.exception.InputMisMatchException;
import com.movieticketbooking.movieticketbooking.exception.InvalidMovieIdException;
import com.movieticketbooking.movieticketbooking.repository.MovieRepository;
import com.movieticketbooking.movieticketbooking.util.MovieTicketMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.movieticketbooking.movieticketbooking.util.MovieTicketMockData.toMovie;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public Movie createMovie(Movie movie) {
    MovieEntity movieEntity = MovieTicketMockData.toMovieEntity(movie);
    movieEntity = movieRepository.save(movieEntity);
    return toMovie(movieEntity);
  }

  @Override
  public Movie getMovieDetails(Long movieId) {
    Optional<MovieEntity> movie = movieRepository.findById(movieId);
    if (movieId < 1) {
      throw new InputMisMatchException("Movie id cannot be negative");
    }
    if (movie.isEmpty()) {
      throw new InvalidMovieIdException("Invalid movie id: " + movieId);
    }
    return toMovie(movie.get());
  }


}
