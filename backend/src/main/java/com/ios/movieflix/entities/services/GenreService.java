package com.ios.movieflix.entities.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Genre;
import com.ios.movieflix.entities.dto.GenreDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	@Transactional(readOnly = true)
	public List<GenreDTO> findAll() {
		List<Genre> list = repository.findAll();
		return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}	
	
	@Transactional(readOnly = true)
	public GenreDTO findById(Long id) {
		Optional<Genre> obj = repository.findById(id);
		Genre us = obj.orElseThrow(() -> new ResourceNotFoundException("Privilégio não existe"));
		return new GenreDTO(us);
	}
	
	@Transactional
	public GenreDTO insert(GenreDTO dto) {
		Genre entity = new Genre();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new GenreDTO(entity);
	}
	
	@Transactional
	public GenreDTO update(Long id, GenreDTO dto) {	
		Genre entity = repository.findById(id).get();
		copyDtoToEntity(dto, entity);
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(GenreDTO dto, Genre entity) {
		entity.setName((dto.getName()));
	}
	
	
}
