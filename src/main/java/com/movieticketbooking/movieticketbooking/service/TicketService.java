package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Ticket;

public interface TicketService {

  Ticket createTicket(Ticket ticket, Long movieId);
}
