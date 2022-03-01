package com.ios.movieflix.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ios.movieflix.entities.dto.MovieDTO;
import com.ios.movieflix.entities.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(
			@RequestParam(value="genreId", required = false) Long id, 
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="size", defaultValue = "12") Integer size,
			@RequestParam(value="direction", defaultValue = "ASC") String direction,
			@RequestParam(value="sort", defaultValue = "title") String title) {
		
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), title);
		Page<MovieDTO> list = movieService.findMovieByGenreId(pageRequest, id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO movieDTO = movieService.findById(id);
		return ResponseEntity.ok().body(movieDTO);
	}
	
	@PostMapping(value="/operation")
	public ResponseEntity<MovieDTO> insertMovie(@Valid @RequestBody MovieDTO dto) {
		MovieDTO movieDTO = movieService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(movieDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(movieDTO);	
	}
	
	@PutMapping(value="/operation/{id}")
	public ResponseEntity<MovieDTO> update(@PathVariable long id, @Valid @RequestBody MovieDTO dto) {
		dto = movieService.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping(value="/operation/{id}")
	public ResponseEntity<MovieDTO> delete(@PathVariable long id) {
		movieService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
