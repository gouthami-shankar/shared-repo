package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import com.movieticketbooking.movieticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public Movie createMovie(Movie movie) {
    MovieEntity movieEntity= toMovieEntity(movie);
    movieEntity=movieRepository.save(movieEntity);
    return toMovie(movieEntity);
  }

  private MovieEntity toMovieEntity(Movie movie) {
    MovieEntity movieEntity=new MovieEntity();
    movieEntity.setId(movie.getId());
    movieEntity.setTitle(movie.getTitle());
    movieEntity.setDirector(movie.getDirector());
    movieEntity.setLanguage(movie.getLanguage());
    movieEntity.setYear(movie.getYear());
    return movieEntity;
  }

  private Movie toMovie(MovieEntity movieEntity) {
    Movie movie=new Movie();
    movie.setId(movieEntity.getId());
    movie.setTitle(movieEntity.getTitle());
    movie.setDirector(movieEntity.getDirector());
    movie.setLanguage(movieEntity.getLanguage());
    movie.setYear(movieEntity.getYear());
    return movie;
  }
}
