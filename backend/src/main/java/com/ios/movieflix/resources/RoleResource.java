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

import com.ios.movieflix.entities.dto.RoleDTO;
import com.ios.movieflix.entities.services.RoleService;

@Controller
@RequestMapping(value = "/roles")
public class RoleResource {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<Page<RoleDTO>> findAll(Pageable pageable) {
		Page<RoleDTO> paged = roleService.findAllPaged(pageable);
		return ResponseEntity.ok(paged);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
		RoleDTO roleDTO = roleService.findById(id);
		return ResponseEntity.ok().body(roleDTO);
	}
	
	@PostMapping
	public ResponseEntity<RoleDTO> insertRole(@Valid @RequestBody RoleDTO dto) {
		RoleDTO roleDTO = roleService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(roleDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(roleDTO);	
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<RoleDTO> update(@PathVariable long id, @Valid @RequestBody RoleDTO dto) {
		dto = roleService.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<RoleDTO> delete(@PathVariable long id) {
		roleService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
