
package com.listwebserv.dao;

import java.security.Timestamp;
import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;


public interface ListServDAO {

	public void addUser(String name, String login, String password, String email, Timestamp created, Timestamp lastLogin, boolean active, boolean admin);
	
	public void addServerName(String serverName, String ipAdress); 
	
	public List<Servers> getListServ(); 
	
	public List<User> getListUser();
	
	
}    