package com.webapp.cloud.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.cloud.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByUsername(String username);
	User findByUsername(String username);
}
