package com.listwebserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.ServersDAO;
import com.listwebserv.domain.Servers;
import com.listwebserv.logic.HTTPConnService;
@Service
public class ServersServiceImpl implements SeversService{

	@Autowired
	private ServersDAO listServDAO;
	
	@Autowired
	private HTTPConnService httpConnService;

	public List<Servers> getListServ(){
		return listServDAO.getListServDB();
	}

	@Override
	public Servers getServers(String hostName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setServers(Servers server) {
		listServDAO.setServerDB(httpConnService.httpUrlServers(server, 2000));		
	};

}
