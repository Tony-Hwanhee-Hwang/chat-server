package com.develian.chatserver.graphql;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.develian.chatserver.model.Chat;
import com.develian.chatserver.publisher.ChatPublisher;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Subscription implements GraphQLSubscriptionResolver {
	@Autowired
	private ChatPublisher chatPublisher;
	
	Subscription(ChatPublisher chatPublisher) {
		this.chatPublisher = chatPublisher;
	}
	
	public Publisher<Chat> newChat() {
		return chatPublisher.getPublisher();
	}
}
