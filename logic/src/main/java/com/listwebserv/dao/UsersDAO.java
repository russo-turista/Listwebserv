
package com.listwebserv.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;


public interface UsersDAO {

	public void setUserDB(String name, String login, String password, String email, Timestamp created, Timestamp lastLogin, boolean active, boolean admin);
	
	public User getUserDB(String login);
	
	
	
	
}    