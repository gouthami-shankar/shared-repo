package com.movieticketbooking.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MOVIE")
public class MovieEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MOVIE_ID")
  private Long id;
  @Column(name = "TITLE")
  private String title;
  @Column(name = "DIRECTOR")
  private String director;
  @Column(name = "LANGUAGE")
  private String language;
  @Column(name = "RELEASE_YEAR")
  private int year;
  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
  private List<TicketEntity> tickets;

}
