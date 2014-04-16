package com.listwebserv.logic;

import org.springframework.beans.factory.annotation.Autowired;

import com.listwebserv.service.SettingsService;

public class ServerRunnable implements Runnable {
	@Autowired
	SettingsService settingsService;
	@Autowired
	
	@Override
	public void run() {
		try {
			
			Thread.sleep(settingsService.getConfig().getTimeRequest());
		} catch (InterruptedException e) {
			 System.err.println(e);
		}
		
	}
}
class ServerStartThread {
	public void startThread(){
		Thread serverThread = new Thread(new ServerRunnable());
		serverThread.start();
	}	
}
