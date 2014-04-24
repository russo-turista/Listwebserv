package com.listwebserv.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.ServersDAO;
import com.listwebserv.domain.Server;
import com.listwebserv.logic.HTTPConnService;

@Service
public class ServersServiceImpl implements ServersService {

	@Autowired
	private ServersDAO listServDAO;

	@Autowired
	SettingsService settingsService;
	@Autowired
	private HTTPConnService httpConnService;
	private Map<String, String > mapIdServers= new HashMap<String, String>();
	public List<Server> getListServ() {
		return listServDAO.getListServDB();
	}

	@Override
	public Server getServers(String hostName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setServers(Server server) {
		if (server.getCreated() == null) {
			System.out.println("Add new Servers");
			listServDAO.setServerDB(httpConnService.httpUrlServers(server,
					settingsService.getConfig().getTimeOutWaiting()));
		} else {
			System.out.println("Update Servers");
			listServDAO.updateSeverDB(httpConnService.httpUrlServers(server,
					settingsService.getConfig().getTimeOutWaiting()));
		}
	}

	@Override
	public Map<String, String > getMapIdServers() {
		for (Server listItem : listServDAO.getListServDB()){
			mapIdServers.put(listItem.getIdServer().toString(), listItem.getHostName());
		}
		return mapIdServers;
	}

	@Override
	public void setMapIdServers(Map<String, String> mapIdServers) {
		//this.mapIdServers = mapIdServers;		
	};

}
