package com.ios.movieflix.entities.dto;

import java.io.Serializable;

import com.ios.movieflix.entities.User;

public class UserReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	
	public UserReviewDTO() {
	}

	public UserReviewDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public UserReviewDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
