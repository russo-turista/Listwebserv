
package com.listwebserv.dao;

import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;


public interface ListServDAO {

	public void addUser(String user, String password);
	
	public void addServerName(String serverName); 
	
	public List<Servers> getListServ(); 
}    