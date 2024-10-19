package com.movieticketbooking.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TICKET")
public class TicketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="TICKET_ID")
  private Long id;
  @Column(name = "TYPE")
  private String type;
  @Column(name = "UNIT_PRICE")
  private double unitPrice;
  @Column(name = "NO_OF_TICKETS")
  private int noOfTickets;
  @Column(name = "PRICE")
  private double price;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")
  private MovieEntity movie;

}
