
package com.listwebserv.dao;


import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;



public interface ServersDAO {

	
	public void setServerDB(Servers server); 
	public List<Servers> getListServDB(); 
	public void updateSeverDB(Servers server);
	public Map<String, Object> getmapIdServersDB();
	public void setmapIdServersDB(Map<Integer,String> mapServers);
	
	
}    