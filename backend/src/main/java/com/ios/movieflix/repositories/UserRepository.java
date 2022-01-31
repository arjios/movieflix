package com.ios.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.movieflix.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
