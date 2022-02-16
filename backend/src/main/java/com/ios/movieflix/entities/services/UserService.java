package com.ios.movieflix.entities.services;


import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.movieflix.entities.Review;
import com.ios.movieflix.entities.Role;
import com.ios.movieflix.entities.User;
import com.ios.movieflix.entities.dto.ReviewDTO;
import com.ios.movieflix.entities.dto.RoleDTO;
import com.ios.movieflix.entities.dto.UserDTO;
import com.ios.movieflix.entities.dto.UserInsertDTO;
import com.ios.movieflix.entities.dto.UserUpdateDTO;
import com.ios.movieflix.entities.services.exceptions.ResourceNotFoundException;
import com.ios.movieflix.repositories.ReviewRepository;
import com.ios.movieflix.repositories.RoleRepository;
import com.ios.movieflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService  {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		return page.map(p -> new UserDTO(p));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User us = obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não existe"));
		return new UserDTO(us);
	}
	
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {	
		User entity = repository.findById(id).get();
		copyDtoToEntity(dto, entity);
		return dto;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.getRoles().clear();
		entity.getReviews().clear();
		for(RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getById(roleDTO.getId());
			entity.getRoles().add(role);
		}
		for(ReviewDTO reviewDTO : dto.getReviews()) {
			Review review = reviewRepository.findById(reviewDTO.getId()).get();
			entity.getReviews().add(review);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			logger.error("Usuario não existe: " + username);
			throw new UsernameNotFoundException("Usuario não existe");
		}
		return user;
	}
	
	
}
