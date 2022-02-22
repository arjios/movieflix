package com.ios.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.movieflix.entities.Genre;
import com.ios.movieflix.entities.Movie;
import com.ios.movieflix.entities.dto.MovieDTO;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Page<MovieDTO> findAllMoviesByGenre(Pageable pageable, Genre genre);
	
	
}
