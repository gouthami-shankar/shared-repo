package com.movieticketbooking.movieticketbooking.repository;

import com.movieticketbooking.movieticketbooking.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

}
