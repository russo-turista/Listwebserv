package com.listwebserv.logic;

//import LiftOff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

public class RequestServers implements Runnable{
	//List<String> hosts = new ArrayList(); 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void createThreadPool(){
		final ExecutorService exec = Executors.newCachedThreadPool();
		 for(int i = 0; i < 5; i++){
		    	exec.execute(new RequestServers());
		    }
		  exec.shutdown();
	}
}

/*class RequestServersRun implements Runnable {
	public void run() {
		
	}
}
*/
/*
 * { List<String> hosts = new ArrayList(); hosts.add("ya.ru");
 * hosts.add("mail.ru");
 * 
 * }
 */