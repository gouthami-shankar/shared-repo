package com.movieticketbooking.movieticketbooking.repository;

import com.movieticketbooking.movieticketbooking.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
