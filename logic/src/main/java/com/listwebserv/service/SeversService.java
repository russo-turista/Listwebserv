package com.listwebserv.service;

import com.listwebserv.domain.Servers;


public interface SeversService {
	public Servers getServers(String hostName);
	public void setServers(Servers servers);
}
