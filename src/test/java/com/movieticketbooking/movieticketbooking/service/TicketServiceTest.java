package com.movieticketbooking.movieticketbooking.service;

import com.movieticketbooking.movieticketbooking.dto.Ticket;
import com.movieticketbooking.movieticketbooking.entity.TicketEntity;
import com.movieticketbooking.movieticketbooking.exception.InvalidMovieIdException;
import com.movieticketbooking.movieticketbooking.repository.MovieRepository;
import com.movieticketbooking.movieticketbooking.repository.TicketRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.movieticketbooking.movieticketbooking.util.MovieTicketMockData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TicketServiceTest {

  @InjectMocks
  TicketServiceImpl ticketService;

  @Mock
  TicketRepository ticketRepository;

  @Mock
  MovieRepository movieRepository;

  @Test
  @DisplayName("should save ticket details")
  void shouldSaveTicketDetailsToDatabase() {
    TicketEntity ticketDetails = getTicketEntityDetails();
    when(movieRepository.findById(anyLong())).thenReturn(Optional.ofNullable(getMovieEntityDetails()));
    when(ticketRepository.save(ticketDetails)).thenReturn(getTicketEntityDetails());
    Ticket ticket = ticketService.createTicket(getTicket(), 1L);
    assertThat(ticket).isNotNull();
    assertThat(ticket.getId()).isEqualTo(1L);
  }

  @Test
  void shouldReturnExceptionIfMovieNotFound() {
    lenient().when(movieRepository.findById(2L)).thenReturn(Optional.ofNullable(getMovieEntityDetails()));
    Throwable throwable = catchThrowable(() -> ticketService.createTicket(getTicket(), 1L));
    assertThat(throwable).isNotNull();
    assertThat(throwable).isInstanceOf(InvalidMovieIdException.class).hasMessageContaining("Movie id not found");
  }
}
