package com.listwebserv.service;

import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Server;


public interface ServersService {
	public Server getServers(String hostName);
	public void setServers(Server server);
	public List<Server> getListServ();
	public Map<String, String> getMapIdServers();
	public void setMapIdServers(Map<String, String> mapServers);
}
