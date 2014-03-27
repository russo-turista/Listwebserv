package com.listwebserv.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.ListServDAO;
import com.listwebserv.domain.Servers;

@Service
public class ServListService {
	@Autowired
	ListServDAO listServDAO;
	
	public void addServerName(String serverName, String ipAdress){
		listServDAO.addServerName(serverName, ipAdress);
	}

	public List<Servers> getListServ(){
		return listServDAO.getListServ();
	};
}
