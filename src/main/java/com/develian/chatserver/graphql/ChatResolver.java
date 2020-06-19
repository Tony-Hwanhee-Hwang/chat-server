package com.develian.chatserver.graphql;

import org.springframework.stereotype.Component;

import com.develian.chatserver.model.Chat;
import com.develian.chatserver.model.User;
import com.develian.chatserver.repository.UserRepository;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChatResolver implements GraphQLResolver<Chat>{
	private UserRepository userRepository;
	
	public User getUser(Long UserId) {
		return userRepository.findById(UserId).orElseThrow(NullPointerException::new);
	}
}
