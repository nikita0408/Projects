package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie insertMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Movie getMovie(Integer movieId) {
		Optional<Movie> optMovie = movieRepository.findById(movieId);
		return optMovie.isPresent() ? optMovie.get() : null;
	}
	
	public List<Movie> getAllMovies(){
		return (List) movieRepository.findAll();
	}
}
