package com.listwebserv.service;

import java.util.List;

import com.listwebserv.domain.Servers;


public interface ServersService {
	public Servers getServers(String hostName);
	public void setServers(Servers servers);
	public List<Servers> getListServ();
}
