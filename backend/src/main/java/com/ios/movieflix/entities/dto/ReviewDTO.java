package com.ios.movieflix.entities.dto;

import java.io.Serializable;

import com.ios.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String text;
	
	private UserDTO userDTO;
	
	private MovieDTO movieDTO;
	
	private UserReviewDTO userReviewDTO;
	
	private MovieReviewDTO movieReviewDTO;
	
	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public ReviewDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieReviewDTO = new MovieReviewDTO(entity.getMovie());
		userReviewDTO = new UserReviewDTO(entity.getUser());
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

	public UserDTO getUserDTO() {
		return userDTO;
	}
	
	public MovieDTO getMovieDTO() {
		return movieDTO;
	}

	public MovieReviewDTO getMovieReviewDTO() {
		return movieReviewDTO;
	}

	public UserReviewDTO getUserReviewDTO() {
		return userReviewDTO;
	}

}
