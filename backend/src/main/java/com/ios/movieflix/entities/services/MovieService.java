package com.ios.movieflix.entities.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Genre;
import com.ios.movieflix.entities.Movie;
import com.ios.movieflix.entities.dto.MovieDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.GenreRepository;
import com.ios.movieflix.repositories.MovieRepository;

@Service
public class MovieService  {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(Pageable pageable) {
		Page<Movie> page = repository.findAll(pageable);
		return page.map(p -> new MovieDTO(p));
	}
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findMovieByGenreId(PageRequest pageRequest, Long id) {
		Page<MovieDTO> obj;
		if(id == null) {
			Page<Movie> page = repository.findAll(pageRequest);
			obj = page.map(p -> new MovieDTO(p));
		}
		else {
			Genre genre = genreRepository.findById(id).get();
			obj = repository.findAllMoviesByGenre(pageRequest, genre);
		}
		return obj;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie us = obj.orElseThrow(() -> new ResourceNotFoundException("Filme não existe"));
		return new MovieDTO(us);
	}
	
	@Transactional
	public MovieDTO insert(MovieDTO dto) {
		Movie entity = new Movie();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new MovieDTO(entity);
	}
	
	@Transactional
	public MovieDTO update(Long id, MovieDTO dto) {	
		Movie entity = repository.findById(id).get();
		copyDtoToEntity(dto, entity);
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(MovieDTO dto, Movie entity) {
		entity.setTitle(dto.getTitle());
		entity.setSubTitle(dto.getSubTitle());
		entity.setYear(dto.getYear());
		entity.setSynopsis(dto.getSynopsis());
		entity.setImgUrl(dto.getImgUrl());
		entity.setGenre(genreRepository.findById(dto.getGenreId()).get());
	}
}
