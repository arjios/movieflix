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

import com.ios.movieflix.entities.dto.GenreDTO;
import com.ios.movieflix.entities.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAll() {
		List<GenreDTO> list = genreService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<GenreDTO> findById(@PathVariable Long id) {
		GenreDTO genreDTO = genreService.findById(id);
		return ResponseEntity.ok().body(genreDTO);
	}
	
	@PostMapping
	public ResponseEntity<GenreDTO> insertGenre(@Valid @RequestBody GenreDTO dto) {
		GenreDTO genreDTO = genreService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(genreDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(genreDTO);	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<GenreDTO> update(@PathVariable long id, @Valid @RequestBody GenreDTO dto) {
		dto = genreService.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<GenreDTO> delete(@PathVariable long id) {
		genreService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
