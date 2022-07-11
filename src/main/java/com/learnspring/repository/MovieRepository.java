package com.learnspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.ini.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
