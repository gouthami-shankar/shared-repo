package com.movieticketbooking.movieticketbooking.repository;

import com.movieticketbooking.movieticketbooking.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
