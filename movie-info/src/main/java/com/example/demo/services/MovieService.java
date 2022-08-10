package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.payloads.MovieDTO;
import com.example.demo.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public Movie insertMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public MovieDTO getMovie(Integer movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(()-> new ResourceNotFoundException("Movie","movieId",movieId+""));
		MovieDTO movieDto = mapToDto(movie);
		return movieDto;
//		Optional<Movie> optMovie = movieRepository.findById(movieId);
//		if (optMovie.isPresent()) {
//			return optMovie.get();
//		} else {
//			throw new ResourceNotFoundException("Movie", "movieId", movieId+"");
//		}
	}

	public List<MovieDTO> getAllMovies() {
		List<Movie> list = movieRepository.findAll();
		return list.stream()
				.map(movie -> mapToDto(movie))
				.collect(Collectors.toList());
	}
	
	private MovieDTO mapToDto(Movie movie) {
		return modelMapper.map(movie, MovieDTO.class);
	}
}
