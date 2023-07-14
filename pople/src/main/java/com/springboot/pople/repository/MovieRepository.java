package com.springboot.pople.repository;

import com.springboot.pople.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {



}
