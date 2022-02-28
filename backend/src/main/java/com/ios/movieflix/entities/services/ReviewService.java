package com.ios.movieflix.entities.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Movie;
import com.ios.movieflix.entities.Review;
import com.ios.movieflix.entities.User;
import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.dto.ReviewInsertDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.MovieRepository;
import com.ios.movieflix.repositories.ReviewRepository;
import com.ios.movieflix.repositories.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<ReviewDTO> findAll() {
		List<Review> list = repository.findAll();
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ReviewDTO findById(Long id) {
		Optional<Review> obj = repository.findById(id);
		Review us = obj.orElseThrow(() -> new ResourceNotFoundException("Review não existe"));
		return new ReviewDTO(us);
	}
	
	@Transactional
	public ReviewDTO insert(ReviewInsertDTO dto) {
		Review entity = new Review();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
	
	@Transactional
	public ReviewDTO update(Long id, ReviewDTO dto) {
		Review entity = repository.findById(id).get();
		entity.setText(dto.getText());
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(ReviewInsertDTO dto, Review entity) {
		entity.setText(dto.getText());
		Optional<Movie> obj = movieRepository.findById(dto.getMovieDTO().getId());
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Filme não existe"));
		entity.setMovie(movie);
		Optional<User> opt = userRepository.findById(dto.getUserDTO().getId());
		User user = opt.orElseThrow(() -> new ResourceNotFoundException("Usuario não existe"));
		entity.setUser(user);
	}
	
}
