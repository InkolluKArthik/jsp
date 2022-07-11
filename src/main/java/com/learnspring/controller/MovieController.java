package com.learnspring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnspring.ini.Movie;
import com.learnspring.service.MovieService;

@Controller
public class MovieController {
		
		@Autowired
		MovieService m;
		@GetMapping("/getmovie")
		@ResponseBody 
		public Movie getmovie()
		{
			return Movie.builder().mid(1).director("gopichand").name("rudra").producer("DVV").length("256").build();
		}
		
		@GetMapping("/h")
		public String ListofMovies(ModelMap map)
		{
			List<Movie> movies= m.getAll();
			map.addAttribute("mess",movies);
			return "list";
		}
		
		@GetMapping("/addmovie")
		public String addNewstudent(@RequestParam int mid,@RequestParam String mname ,@RequestParam String producer,@RequestParam String director,@RequestParam String length,ModelMap model) {
			
			Movie movie=Movie.builder().mid(mid).director(director).length(length).name(mname).producer(producer).build();
			m.addMovie(movie);
			
			List<Movie> movies= m.getAll();
			model.addAttribute("mess",movies);
			return "list";
		}
		@GetMapping("/del")
		public String deletedata(@RequestParam int mid,ModelMap map)
		{
			m.deleteMovie(Movie.builder().mid(mid).build());
			List<Movie> movies= m.getAll();
			map.addAttribute("mess",movies);
			return "list";
		}
	}

