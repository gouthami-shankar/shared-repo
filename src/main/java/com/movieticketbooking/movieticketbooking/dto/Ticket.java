package com.movieticketbooking.movieticketbooking.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

  private Long id;
  private String type;
  private double unitPrice;
  private int noOfTickets;
  private double price;
}
