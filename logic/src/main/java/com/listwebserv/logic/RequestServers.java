package com.listwebserv.logic;

//import LiftOff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.*;

import javax.inject.Inject;

import com.listwebserv.*;

public class RequestServers implements Runnable {
	@Inject
	private HostServers servers;
	private int i=0;
	private String hostName;
	private String hostPort;
	public Map<String, String> addressIP = new HashMap<String, String>();
	Map<String, String> listHosts = new HashMap();

	public void getListHosts(String hostName, String hostPort) {
		listHosts.put(hostName, hostPort);
	}
	public Map<String, String> getAddressIP(){
		return addressIP;
	}

	@Override
	public void run() {
		try {
			servers.httpUrlServers(hostName, hostPort);
			System.out.println("Thread number= " + i++);
			TimeUnit.MILLISECONDS.sleep(1000);
			 
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	public void createThreadPool() {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		 * for (int i = 0; i < listHosts.size(); i++) { exec.execute(new
		 * RequestServers()); }
		 
		for (Entry<String, String> entry : listHosts.entrySet()) {
			hostName = entry.getKey(); 
			hostPort = entry.getValue();
			exec.execute(new RequestServers());
		}
		exec.shutdown();

	}*/
}
/*
 * class RequestServersRun implements Runnable { public void run() {
 * 
 * } }
 */
/*
 * { List<String> hosts = new ArrayList(); hosts.add("ya.ru");
 * hosts.add("mail.ru");
 * 
 * }
 */