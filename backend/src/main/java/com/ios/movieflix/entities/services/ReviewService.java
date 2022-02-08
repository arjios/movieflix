package com.ios.movieflix.entities.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Review;
import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ReviewDTO> findAllPaged(Pageable pageable) {
		Page<Review> page = repository.findAll(pageable);
		return page.map(p -> new ReviewDTO(p));
	}
	
	@Transactional(readOnly = true)
	public ReviewDTO findById(Long id) {
		Optional<Review> obj = repository.findById(id);
		Review us = obj.orElseThrow(() -> new ResourceNotFoundException("Indice review não existe"));
		return new ReviewDTO(us);
	}
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Review entity = new Review();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
	
	@Transactional
	public ReviewDTO update(Long id, ReviewDTO dto) {	
		Review entity = repository.findById(id).get();
		copyDtoToEntity(dto, entity);
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(ReviewDTO dto, Review entity) {
		entity.setText(dto.getText());
	}
	
}
