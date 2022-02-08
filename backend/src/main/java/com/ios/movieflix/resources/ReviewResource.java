package com.ios.movieflix.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.services.ReviewService;

@Controller
@RequestMapping(value = "/reviews")
public class ReviewResource {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Page<ReviewDTO>> findAll(Pageable pageable) {
		Page<ReviewDTO> paged = reviewService.findAllPaged(pageable);
		return ResponseEntity.ok(paged);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
		ReviewDTO reviewDTO = reviewService.findById(id);
		return ResponseEntity.ok().body(reviewDTO);
	}
	
	@PostMapping
	public ResponseEntity<ReviewDTO> insertReview(@Valid @RequestBody ReviewDTO dto) {
		ReviewDTO reviewDTO = reviewService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(reviewDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(reviewDTO);	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ReviewDTO> update(@PathVariable long id, @Valid @RequestBody ReviewDTO dto) {
		dto = reviewService.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<ReviewDTO> delete(@PathVariable long id) {
		reviewService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
