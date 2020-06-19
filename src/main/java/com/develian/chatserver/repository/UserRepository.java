package com.develian.chatserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develian.chatserver.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	/*
	 * @Query("SELECT p FROM User p JOIN FETCH p.Chat") List<User> findAll();
	 */
}
