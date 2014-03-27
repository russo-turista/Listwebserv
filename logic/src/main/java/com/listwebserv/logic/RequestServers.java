package com.listwebserv.logic;

//import LiftOff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.listwebserv.service.ServListService;

@Component
public class RequestServers  {
	@Autowired
	private HostServers servers;
	
	@Autowired
	private ServListService servListService;
	
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
			//listHostsFull.put(entry.getKey(),servers.httpUrlServers(hostName, hostPort));
			servListService.addServerName(entry.getKey());
		}
		return listHostsFull;
				
	}
}
