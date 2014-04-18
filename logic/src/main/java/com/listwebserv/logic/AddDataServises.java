package com.listwebserv.logic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.listwebserv.domain.Servers;
import com.listwebserv.service.ServersService;
import com.listwebserv.service.SettingsService;

@Component
public class AddDataServises {
	@Autowired
	private HTTPConnService httpConnService;
	@Autowired
	private ServersService seversService;
	@Autowired
	private SettingsService settingsService;
	
	//private static final Logger logger = Logger.getLogger(AddDataServises.class);
	public void requestService() {
		for (Servers severs : seversService.getListServ()) {
			//logger.info("currnet server= " + severs.getHostName());
			System.out.println("currnet server= " + severs.getHostName());
			seversService.setServers(httpConnService.httpUrlServers(severs,
					settingsService.getConfig().getTimeOutWaiting()));
		}
	}
}
