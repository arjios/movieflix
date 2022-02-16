package com.ios.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.movieflix.entities.Genre;
import com.ios.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByGenre(Genre genre);
	
}
