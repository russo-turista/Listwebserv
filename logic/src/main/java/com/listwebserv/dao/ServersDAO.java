
package com.listwebserv.dao;


import java.util.List;
import com.listwebserv.domain.Servers;



public interface ServersDAO {

	
	public void setServerDB(Servers server); 
	public List<Servers> getListServDB(); 
	public void updateSeverDB(Servers server);
	
	
}    