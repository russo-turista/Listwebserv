package com.listwebserv.security;

import com.listwebserv.domain.User;

public interface UserService {
	public User getUser(String name);
	public void setUser(User user);
}
