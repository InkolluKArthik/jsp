package com.learnspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnspring.ini.Movie;
import com.learnspring.repository.MovieRepository;

@Service
public class MovieService {

		@Autowired
		MovieRepository repository;
		
		public List<Movie> getAll()
		{
			return repository.findAll();
		}
		public void addMovie(Movie movie) {
			 repository.save(movie);
		}
		public void deleteMovie(Movie movie)
		{
			repository.delete(movie);
		}
	}

