
package com.listwebserv.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;


public interface UsersDAO {

	public void setUserDB(User user);
	
	public User getUserDB(String login);
	public User getUserDB(Long userID);
	public List<User> getListUserDB(); 
	
	
	
}    