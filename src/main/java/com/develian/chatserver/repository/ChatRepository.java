package com.develian.chatserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develian.chatserver.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
}
