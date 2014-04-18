package com.listwebserv.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.listwebserv.domain.Servers;
import com.listwebserv.service.SettingsService;

@Component
public class RequestServers  {
	
	@Autowired
	private SettingsService settingsService;
	@Autowired
	AddDataServises addDataServises;
	@Autowired
	private ScheduledRequestServers scheduledRequest;
	@Autowired
	private Servers servers;
	
	/*private RequestServers(){
		startRequest();
	}*/
	public void startRequest(){
		addDataServises.requestService();
		scheduledRequest.scheduledStart(settingsService.getConfig().getTimeRequest());
	}
}

