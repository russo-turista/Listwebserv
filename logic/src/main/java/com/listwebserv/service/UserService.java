package com.listwebserv.service;

import java.util.List;
import java.util.Map;

import com.listwebserv.domain.User;

public interface UserService {
	public User getUser(Long userId);
	public User getUser(String login);
	public void setUser(User user);
	public List<User> getListUsers();
	public Map<String, String> getMapIdUsers();
	public void setMapIdUsers(Map<String, String> mapUsers);
	
}
