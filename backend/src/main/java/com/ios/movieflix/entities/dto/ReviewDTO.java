package com.ios.movieflix.entities.dto;

import java.io.Serializable;

import com.ios.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String text;
	
	private MovieDTO movieDTO;
	
	private UserDTO userDTO;

	public ReviewDTO() {
	}

	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.movieDTO = new MovieDTO(entity.getMovie());
		this.userDTO = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MovieDTO getMovieDTO() {
		return movieDTO;
	}

	public Long setMovieId(Long movieId) {
		return movieId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}
}
