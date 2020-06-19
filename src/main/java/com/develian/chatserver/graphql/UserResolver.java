package com.develian.chatserver.graphql;

import org.springframework.stereotype.Component;

import com.develian.chatserver.model.User;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {

}
