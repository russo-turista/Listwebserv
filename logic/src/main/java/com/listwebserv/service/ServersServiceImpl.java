package com.listwebserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.listwebserv.dao.ServersDAO;
import com.listwebserv.domain.Servers;

public class ServersServiceImpl implements SeversService{

	@Autowired
	ServersDAO listServDAO;
	
	public void addServerName(String serverName, String ipAdress){
		listServDAO.addServerName(serverName, ipAdress);
	}

	public List<Servers> getListServ(){
		return listServDAO.getListServ();
	}

	@Override
	public Servers getServers(String hostName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setServers(Servers servers) {
		listServDAO.addServerName(serverName, ipAdress);
		
	};

}
