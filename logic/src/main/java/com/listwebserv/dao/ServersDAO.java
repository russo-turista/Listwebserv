
package com.listwebserv.dao;


import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Server;



public interface ServersDAO {

	
	public void setServerDB(Server server); 
	public List<Server> getListServDB(); 
	public void updateSeverDB(Server server);
	public Map<String, Object> getmapIdServersDB();
	public void setmapIdServersDB(Map<Integer,String> mapServers);
	
	
}    