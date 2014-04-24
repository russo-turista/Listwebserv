package com.listwebserv.logic;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.listwebserv.domain.Server;
import com.listwebserv.service.enums.ServersStatusEnum;

import java.net.*;

@Component
public class HTTPConnService {
	private static final Logger logger = Logger.getLogger(HTTPConnService.class);
	public static final  String PROTOCOL = "HTTP";
	//private Logger logger = Logger.getLogger(HTTPConnService.class);
	
	
	public Server httpUrlServers(Server server, int timeOutWaiting )  {
		
		
		try{			
			URL url = new URL(PROTOCOL, server.getHostName(), server.getHostPort(),"/");
			InetAddress address = InetAddress.getByName(url.getHost());	
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(timeOutWaiting * 1000);
			
			int status = urlCon.getResponseCode();
			
			if (status == HttpURLConnection.HTTP_OK){
				logger.info("status= " + status);
				server.setState(ServersStatusEnum.OK);
			}
			if (status != HttpURLConnection.HTTP_OK && status < 500 ) {
				logger.info("status= " + status);
				//System.out.println("status= " + status);
				server.setState(ServersStatusEnum.WARN);
			} 
			if (status >= 500){
				logger.info("status= " + status);
				//System.out.println("status= " + status);
				server.setState(ServersStatusEnum.FAIL);
			}
			
			server.setIpAddress(address.getHostAddress().toString());
			server.setResponse(urlCon.getResponseMessage());
			
			return server;
			
		} catch (Exception e) {
			//System.out.println("Error connection: " + e.getMessage());
			logger.error("Error connection: " + e);
			server.setState(ServersStatusEnum.FAIL);
			return server;
		}
		
	}

}