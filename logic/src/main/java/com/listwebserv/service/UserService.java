package com.listwebserv.service;

import com.listwebserv.domain.User;

public interface UserService {
	public User getUser(String name);
	public void setUser(User user);
}
