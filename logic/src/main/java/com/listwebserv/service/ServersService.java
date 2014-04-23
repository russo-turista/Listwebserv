package com.listwebserv.service;

import java.util.List;
import java.util.Map;

import com.listwebserv.domain.Servers;


public interface ServersService {
	public Servers getServers(String hostName);
	public void setServers(Servers servers);
	public List<Servers> getListServ();
	public Map<String, String> getMapIdServers();
	public void setMapIdServers(Map<String, String> mapServers);
}
