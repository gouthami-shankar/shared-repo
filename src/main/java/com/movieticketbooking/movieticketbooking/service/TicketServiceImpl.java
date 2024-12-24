package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Ticket;
import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import com.movieticketbooking.movieticketbooking.entity.TicketEntity;
import com.movieticketbooking.movieticketbooking.exception.InvalidMovieIdException;
import com.movieticketbooking.movieticketbooking.repository.MovieRepository;
import com.movieticketbooking.movieticketbooking.repository.TicketRepository;
import com.movieticketbooking.movieticketbooking.util.MovieTicketMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private MovieRepository movieRepository;

  @Override
  public Ticket createTicket(Ticket ticket, Long movieId) {
    MovieEntity movieEntity = movieRepository.findById(movieId).orElseThrow(() -> new InvalidMovieIdException("Movie id not found: "+movieId));
    ticket.setTitle(movieEntity.getTitle());
    double ticketPrice = ticket.getNoOfTickets() * ticket.getUnitPrice();
    //Using Builder method
    TicketEntity ticketEntity =TicketEntity.builder()
      .id(ticket.getId())
      .noOfTickets(ticket.getNoOfTickets())
      .unitPrice(ticket.getUnitPrice())
      .price(ticketPrice)
      .type(ticket.getType())
      .movie(movieEntity)
      .build();
    ticketEntity = ticketRepository.save(ticketEntity);
    return MovieTicketMockData.fromTicketEntity(ticketEntity);
  }
}

