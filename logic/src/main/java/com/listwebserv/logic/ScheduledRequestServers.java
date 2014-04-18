package com.listwebserv.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static java.util.concurrent.TimeUnit.*;
@Component
public class ScheduledRequestServers {
	final ScheduledExecutorService scheduler = Executors
			.newSingleThreadScheduledExecutor();

	public void scheduledStart(int timeRequest) {
		scheduler.scheduleWithFixedDelay(new ServersRunnable(), 0,
				timeRequest, SECONDS);
	}
	public void scheduledStop(){
		scheduler.shutdown();
	}

}

class ServersRunnable implements Runnable{
	
	//private static final Logger logger = Logger.getLogger(ServersRunnable.class);
	@Autowired
	private AddDataServises addDataServises;
	private int i = 0;

	@Override
	public void run() {
		System.out.println("Run thread " + i);
		try{
			addDataServises.requestService();
		}catch(Exception e){
			System.out.println("Execption: " + e);
		}
		System.out.println("Stop thread" + i++);
	}
}
