package com.movieticketbooking.movieticketbooking.util;

import com.movieticketbooking.movieticketbooking.dto.Movie;
import com.movieticketbooking.movieticketbooking.dto.Ticket;
import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import com.movieticketbooking.movieticketbooking.entity.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieTicketMockData {

  public static MovieEntity toMovieEntity(Movie movie) {
    MovieEntity movieEntity = new MovieEntity();
    movieEntity.setId(movie.getId());
    movieEntity.setTitle(movie.getTitle());
    movieEntity.setDirector(movie.getDirector());
    movieEntity.setLanguage(movie.getLanguage());
    movieEntity.setYear(movie.getYear());
    return movieEntity;
  }

  public static Movie toMovie(MovieEntity movieEntity) {
    Movie movie = new Movie();
    movie.setId(movieEntity.getId());
    movie.setTitle(movieEntity.getTitle());
    movie.setDirector(movieEntity.getDirector());
    movie.setLanguage(movieEntity.getLanguage());
    movie.setYear(movieEntity.getYear());
    return movie;
  }

  public static Ticket fromTicketEntity(TicketEntity ticketEntity) {
    Ticket ticket = new Ticket();
    ticket.setId(ticketEntity.getId());
    ticket.setType(ticketEntity.getType());
    ticket.setNoOfTickets(ticketEntity.getNoOfTickets());
    ticket.setUnitPrice(ticketEntity.getUnitPrice());
    ticket.setPrice(ticketEntity.getPrice());
    ticket.setTitle(ticketEntity.getMovie().getTitle());
    return ticket;
  }

  public static Movie getMovieDetails() {
    return Movie.builder()
      .id(1L)
      .title("Taare Zameen Paar")
      .director("Amir Khan")
      .language("Hindi")
      .year(2007)
      .build();
  }

  public static MovieEntity getMovieEntityDetails() {
    return MovieEntity.builder()
      .id(1L)
      .title("Taare Zameen Paar")
      .director("Amir Khan")
      .language("Hindi")
      .year(2007)
      .build();
  }

  public static TicketEntity getTicketEntityDetails() {
    return TicketEntity.builder()
      .id(1L)
      .noOfTickets(3)
      .unitPrice(300.00)
      .type("Balcony")
      .price(900)
      .movie(getMovieEntityDetails())
      .build();
  }

  public static Ticket getTicket() {
    return Ticket.builder()
      .id(1L)
      .noOfTickets(3)
      .unitPrice(300.00)
      .type("Balcony")
      .price(900)
      .title("Tare Zameen Paar")
      .build();
  }


}
