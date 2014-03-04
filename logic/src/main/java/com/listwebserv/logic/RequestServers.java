package com.listwebserv.logic;

//import LiftOff;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class RequestServers implements Callable<String>  {
	@Inject
	private HostServers servers;
	private int i=0;
	private String hostName;
	private Integer hostPort;
	//public Map<String, String> addressIP = new HashMap<String, String>();
	//Map<String, String> listHosts = new HashMap();
	
	
	public RequestServers(String hostName, Integer hostPort) {
		this.hostName = hostName;
		this.hostPort = hostPort;
	}
	/*public Map<String, String> getAddressIP(){
		return addressIP;
	}*/

	@Override
	public String  call() throws Exception {
		try {
			System.out.println("Thread number= " + i++);
			TimeUnit.MILLISECONDS.sleep(1000);
			return servers.httpUrlServers(hostName, hostPort);
			
		} catch (IOException | InterruptedException e) {
			return e.toString();
		}
		
	}
}
