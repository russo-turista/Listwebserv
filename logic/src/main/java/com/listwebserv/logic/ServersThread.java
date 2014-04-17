package com.listwebserv.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.listwebserv.service.SettingsService;

public class ServersThread {
	public void startThread(){
		Thread serverThread = new Thread(new ServersRunnable());
		serverThread.start();
	}	
}

class ServersRunnable implements Runnable {
	@Autowired
	SettingsService settingsService;
	
	@Override
	public void run() {
	//	try {
			System.out.println("Run thread");
			System.out.println("Time sleep= " + settingsService.getConfig().getTimeRequest() * 1000 );
			//Thread.sleep(settingsService.getConfig().getTimeRequest() * 1000);
			System.out.println("Stop thread");
		//} catch (InterruptedException e) {
		//	 System.err.println(e);
		//}
		
	}
}
