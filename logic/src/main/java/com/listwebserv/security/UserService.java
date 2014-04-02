package com.listwebserv.security;

import com.listwebserv.domain.User;

public interface UserService {
	public User getUser(String login);
	public void setUser(User user);
}
