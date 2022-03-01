package com.ios.movieflix.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.services.ReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<List<ReviewDTO>> findAll() {
		List<ReviewDTO> list = reviewService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
		ReviewDTO reviewDTO = reviewService.findById(id);
		return ResponseEntity.ok().body(reviewDTO);
	}
	
	@PostMapping
	public ResponseEntity<ReviewDTO> insertReview(@RequestBody ReviewDTO dto) {
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
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ReviewDTO> delete(@PathVariable long id) {
		reviewService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
