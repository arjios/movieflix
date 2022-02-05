package com.ios.movieflix.entities.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Role;
import com.ios.movieflix.entities.dto.RoleDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RoleDTO> findAllPaged(Pageable pageable) {
		Page<Role> page = repository.findAll(pageable);
		return page.map(p -> new RoleDTO(p));
	}
	
	@Transactional(readOnly = true)
	public RoleDTO findById(Long id) {
		Optional<Role> obj = repository.findById(id);
		Role us = obj.orElseThrow(() -> new ResourceNotFoundException("Privilégio não existe"));
		return new RoleDTO(us);
	}
	
	@Transactional
	public RoleDTO insert(RoleDTO dto) {
		Role entity = new Role();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new RoleDTO(entity);
	}
	
	@Transactional
	public RoleDTO update(Long id, RoleDTO dto) {	
		Role entity = repository.findById(id).get();
		copyDtoToEntity(dto, entity);
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(RoleDTO dto, Role entity) {
		entity.setAuthority(dto.getAuthority());
	}
	
	
}
