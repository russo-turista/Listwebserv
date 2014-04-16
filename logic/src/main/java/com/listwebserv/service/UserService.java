package com.listwebserv.service;

import com.listwebserv.domain.User;

public interface UserService {
	public User getUser(String login);
	public void setUser(User user);
}
