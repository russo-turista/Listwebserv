package com.listwebserv.logic;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThreadPool {
	
public void createPool(Map<String, String> listHosts){
		ExecutorService exec = Executors.newCachedThreadPool();
		for (Entry<String, String> entry : listHosts.entrySet()) {
			hostName = entry.getKey(); 
			hostPort = entry.getValue();
			exec.execute(new RequestServers());
		}
		exec.shutdown();
	}
}
