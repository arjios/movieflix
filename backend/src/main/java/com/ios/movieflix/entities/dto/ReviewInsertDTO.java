package com.ios.movieflix.entities.dto;

import java.io.Serializable;


public class ReviewInsertDTO  extends ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long reviewMovieId;
	
	public ReviewInsertDTO() {
		super();
	}

	public Long getReviewMovieId() {
		return reviewMovieId;
	}

}
