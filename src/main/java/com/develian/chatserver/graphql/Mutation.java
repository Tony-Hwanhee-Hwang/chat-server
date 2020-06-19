package com.develian.chatserver.graphql;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.develian.chatserver.model.Chat;
import com.develian.chatserver.model.User;
import com.develian.chatserver.publisher.ChatPublisher;
import com.develian.chatserver.repository.ChatRepository;
import com.develian.chatserver.repository.UserRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Mutation implements GraphQLMutationResolver {
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ChatPublisher chatPublisher;
	
	public Mutation(ChatRepository chatRepository, UserRepository userRepository,ChatPublisher chatPublisher) {
		this.chatRepository = chatRepository;
		this.userRepository = userRepository;
		this.chatPublisher = chatPublisher;
	}	
	
	public Chat write(Long userId, String message){
		
		Chat chat = new Chat();
		
		chat.setMessage(message);
		chat.setSender(userRepository.findById(userId).orElseThrow(NullPointerException::new));
		chat.setDate(new Date().toString());
		chat.setIsRead(false);
		log.info("call write mutation : {}" + chat);
		chatRepository.save(chat);
		chatPublisher.publish(chat);
		return chat;
	}
	
	public User makeUser(String nickName, String avatarUrl) {
		User user = new User();
		user.setNickName(nickName);
		user.setAvatarUrl(avatarUrl);
		userRepository.save(user);
		
		return user;
	}
}
