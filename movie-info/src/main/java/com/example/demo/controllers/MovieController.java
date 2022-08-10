package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Movie;
import com.example.demo.payloads.MovieDTO;
import com.example.demo.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/api/movies/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable("id") int movieId) {
		MovieDTO movieDto = movieService.getMovie(movieId);
		return new ResponseEntity<MovieDTO>(movieDto, HttpStatus.OK);
//		if(movie!=null)
//		{
//			return new ResponseEntity<Movie>(movie, HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}
	
	@GetMapping("/api/movies")
	public ResponseEntity<List<MovieDTO>> getMovie() {
		List<MovieDTO> movieList = movieService.getAllMovies();
		return new ResponseEntity<List<MovieDTO>>(movieList, HttpStatus.OK);
	}
	
	
}
