
package com.listwebserv.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;


public interface ServersDAO {

	
	public void addServer(String serverName, String ipAdress); 
	
	public List<Servers> getListServ(); 	
	
	
}    