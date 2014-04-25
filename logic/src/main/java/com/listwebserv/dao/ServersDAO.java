
package com.listwebserv.dao;


import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;



public interface ServersDAO {

	
	public void setServerDB(Server server); 
	public List<Server> getListServDB(); 
	public void updateSeverDB(Server server);
	public Map<String, Object> getmapIdServersDB();
	public void setMapIdServersDB(Map<Integer,String> mapServers);
	public void setServerToUsersDB(Long idServer, Long listUser);
	public List<Server> getServersToUserDB(Long idUser);
	
}    