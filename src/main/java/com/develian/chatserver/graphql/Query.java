package com.develian.chatserver.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.develian.chatserver.model.Chat;
import com.develian.chatserver.repository.ChatRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private ChatRepository chatRepository; 
	
	public Query(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}	
	
	public List<Chat> chatting(){
		log.info("call Query Resolver : " + chatRepository.count());
		return chatRepository.findAll();
	}
}