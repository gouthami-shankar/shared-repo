package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import com.movieticketbooking.movieticketbooking.exception.InputMisMatchException;
import com.movieticketbooking.movieticketbooking.exception.InvalidMovieIdException;
import com.movieticketbooking.movieticketbooking.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.movieticketbooking.movieticketbooking.util.MovieTicketMockData.getMovieDetails;
import static com.movieticketbooking.movieticketbooking.util.MovieTicketMockData.getMovieEntityDetails;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MovieServiceTest {

  @Mock
  private MovieRepository movieRepository;

  @InjectMocks
  private MovieServiceImpl movieService;

  @Test
  @DisplayName("should save movie details")
  void shouldSaveMovieDetailsToDatabase() {
    MovieEntity movieDetails = getMovieEntityDetails();
    when(movieRepository.save(movieDetails)).thenReturn(getMovieEntityDetails());
    Movie movie = movieService.createMovie(getMovieDetails());
    assertThat(movie).isNotNull();
    assertThat(movie.getId()).isEqualTo(1L);
  }

  @Test
  @DisplayName("Get movie details by movie id")
  void shouldGetMovieDetails() {
    Movie movie = getMovieDetails();
    when(movieRepository.findById(1L)).thenReturn(Optional.of(getMovieEntityDetails()));
    Movie movieDetails = movieService.getMovieDetails(1L);
    assertThat(movieDetails).isNotNull();
  }

  @Test
  @DisplayName("Should throw exception when movie id is invalid")
  void shouldThrowExceptionWhenMovieNotFound() {
    when(movieRepository.findById(2L)).thenReturn(Optional.empty());
    Throwable throwable = catchThrowable(() -> movieService.getMovieDetails(2L));
    assertThat(throwable).isNotNull();
    assertThat(throwable).isInstanceOf(InvalidMovieIdException.class).hasMessageContaining("Invalid movie id");
  }

  @Test
  @DisplayName("Should throw exception when movie id is negative")
  void shouldThrowExceptionWhenMovieIdIsNegative() {
    Throwable throwable = catchThrowable(() -> movieService.getMovieDetails(-1L));
    assertThat(throwable).isNotNull();
    assertThat(throwable).isInstanceOf(InputMisMatchException.class).hasMessageContaining("Movie id cannot be negative");
  }

}
