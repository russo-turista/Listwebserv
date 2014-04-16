package com.listwebserv.logic;

//import LiftOff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.listwebserv.service.SeversService;

@Component
public class RequestServers  {
	@Autowired
	private HTTPConnService httpConnService;
	
	@Autowired
	private SeversService seversService;
	
	private String hostName;
	private Integer hostPort;
	public Map<String, String> listHostsFull = new HashMap<String, String>();

	/*public Map<String, String> getAddressIP(){
		return addressIP;
	}*/

	public Map<String, String> listsServers(Map<String, Integer> listHosts) throws Exception{
		for (Entry<String, Integer> entry : listHosts.entrySet()) {
			hostName = entry.getKey();
			hostPort = entry.getValue();
			//seversService.addServerName(entry.getKey(), httpConnService.httpUrlServers(hostName, hostPort));
		//	seversService.setServers(servers);
		}
		return listHostsFull;
				
	}
}
