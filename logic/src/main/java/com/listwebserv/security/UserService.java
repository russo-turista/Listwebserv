package com.listwebserv.security;

import com.listwebserv.domain.User;

public interface UserService {
	 User getUser(String login);
}
