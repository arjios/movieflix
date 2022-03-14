package com.ios.movieflix.entities.dto;

import java.io.Serializable;

import com.ios.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long movieId;
	private Long userId;
	private String email;
	private String text;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Review entity) {
		movieId = entity.getId().getMovie().getId();
		userId = entity.getId().getUser().getId();
		email = entity.getId().getUser().getEmail();
		text = entity.getText();
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getUserId() {
		return userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
