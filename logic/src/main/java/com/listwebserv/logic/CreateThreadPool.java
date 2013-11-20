package com.listwebserv.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component
public class CreateThreadPool {

	private String hostName;
	private String hostPort;
	public Map<String, String> listHosts = new HashMap<String, String>();
	public Map<String, String> resaultListHosts = new HashMap<String, String>();
	
	public void setListHosts(String hostName, String hostPort) {
		listHosts.put(hostName, hostPort);
		createPool(listHosts);
	}
	public Map<String, String> getListHosts(){		
		return resaultListHosts;
	}
	public void createPool(Map<String, String> listHosts) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (Entry<String, String> entry : listHosts.entrySet()) {
			hostName = entry.getKey();
			hostPort = entry.getValue();
			results.add(exec.submit(new RequestServers(hostName, hostPort)));
			for(Future<String> fs : results)
			      try {
			        // Вызов get() блокируется до завершения;:
			        System.out.println(fs.get());
			        resaultListHosts.put(hostName, fs.get());
			      } catch(InterruptedException e) {
			        System.out.println(e);
			        return;
			      } catch(ExecutionException e) {
			        System.out.println(e);
			      } finally {
			        exec.shutdown();
			      }
			
		}
		exec.shutdown();
	}
}
