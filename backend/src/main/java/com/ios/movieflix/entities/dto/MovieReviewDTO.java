package com.ios.movieflix.entities.dto;

import java.io.Serializable;

import com.ios.movieflix.entities.Movie;

public class MovieReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	
	public MovieReviewDTO() {
	}

	public MovieReviewDTO(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	

	public MovieReviewDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
