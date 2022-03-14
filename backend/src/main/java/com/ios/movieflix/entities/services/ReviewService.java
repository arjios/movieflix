package com.ios.movieflix.entities.services;


import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Movie;
import com.ios.movieflix.entities.Review;
import com.ios.movieflix.entities.ReviewPK;
import com.ios.movieflix.entities.User;
import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.MovieRepository;
import com.ios.movieflix.repositories.ReviewRepository;
import com.ios.movieflix.repositories.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReviewRepository repository;
	
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
	public ReviewDTO insert(ReviewDTO dto) {
		Review review = new Review();
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		User user = userRepository.findByEmail(dto.getEmail());
		if(user != null) {
			review.setMovie(movie);
			review.setUser(user);
			review.setText(dto.getText());
			review.setCreatedAt(Instant.now());
			review = repository.saveAndFlush(review);
		}
		return new ReviewDTO(review);
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
}
