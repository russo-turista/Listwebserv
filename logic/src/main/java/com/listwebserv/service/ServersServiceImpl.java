package com.listwebserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.ServersDAO;
import com.listwebserv.domain.Servers;
import com.listwebserv.logic.HTTPConnService;

@Service
public class ServersServiceImpl implements ServersService {

	@Autowired
	private ServersDAO listServDAO;

	@Autowired
	SettingsService settingsService;
	@Autowired
	private HTTPConnService httpConnService;

	public List<Servers> getListServ() {
		return listServDAO.getListServDB();
	}

	@Override
	public Servers getServers(String hostName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setServers(Servers server) {
		if (server.getCreated() == null) {
			System.out.println("Add new Servers");
			listServDAO.setServerDB(httpConnService.httpUrlServers(server,
					settingsService.getConfig().getTimeOutWaiting()));
		} else {
			System.out.println("Update Servers");
			listServDAO.updateSeverDB(httpConnService.httpUrlServers(server,
					settingsService.getConfig().getTimeOutWaiting()));
		}
	};

}
