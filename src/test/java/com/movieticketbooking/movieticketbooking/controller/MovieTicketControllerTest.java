package com.movieticketbooking.movieticketbooking.controller;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Objects;

import static com.movieticketbooking.movieticketbooking.util.MovieTicketMockData.getMovieDetails;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieTicketControllerTest {

  private static final String LOCALHOST = "http://localhost:";
  private static final String API_URL = "/theater/movie";

  @LocalServerPort
  private int port;

  @Autowired
  protected TestRestTemplate restTemplate;

  @Mock
  private MovieService movieService;

  private static void addMessageConverters(TestRestTemplate testRestTemplate) {
    testRestTemplate.getRestTemplate().getMessageConverters().add(new FormHttpMessageConverter());
    testRestTemplate.getRestTemplate().getMessageConverters().add(new MappingJackson2HttpMessageConverter());
  }

  @BeforeEach
  public void setUp() {
    addMessageConverters(restTemplate);
  }

  @Test
  void shouldSaveMovieDetails() {
    //GIVEN
    Movie movie = getMovieDetails();
    when(movieService.createMovie(movie)).thenReturn(movie);

    //WHEN
    String url = LOCALHOST + port + API_URL;
    HttpEntity<Movie> httpEntity = new HttpEntity<>(movie, getHttpHeadersWithBearerToken());
    ResponseEntity<Movie> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Movie.class);

    //THEN
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(Objects.requireNonNull(responseEntity.getBody()).getId()).isEqualTo(1L);
    assertThat(responseEntity.getBody().getTitle()).isEqualTo(movie.getTitle());
    assertThat(responseEntity.getBody().getYear()).isEqualTo(movie.getYear());
    assertThat(responseEntity.getBody().getDirector()).isEqualTo(movie.getDirector());
  }

  private static HttpHeaders getHttpHeadersWithBearerToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer" + "token-valid-scope");
    return headers;
  }
}
