package com.movieticketbooking.movieticketbooking.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

  private Long id;
  private String title;
  private String director;
  private String language;
  private int year;
}
