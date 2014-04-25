package com.listwebserv.service;

import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;


public interface ServersService {
	public Server getServers(String hostName);
	public void setServers(Server server);
	public List<Server> getListServ();
	public Map<String, String> getMapIdServers();
	public void setMapIdServers(Map<String, String> mapServers);
	public void setServerToUsers(List<String> listServers, List<String> listUsers);
	public List<Server> getServersToUser(Long idUser);
	
}
