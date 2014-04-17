package com.listwebserv.logic;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.listwebserv.domain.Servers;
import com.listwebserv.service.enums.ServersStatusEnum;

import java.net.*;

@Component
public class HTTPConnService {
	//public StringBuilder stringTableBuild = new StringBuilder();
	public static final  String PROTOCOL = "HTTP";
	//private Logger logger = Logger.getLogger(HTTPConnService.class);
	
	
	public Servers httpUrlServers(Servers server, Integer timeOutWaiting )  {
		
		
		try{			
			URL url = new URL(PROTOCOL, server.getHostName(), server.getHostPort(),"/");
			InetAddress address = InetAddress.getByName(url.getHost());	
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(timeOutWaiting * 1000);
			
			int status = urlCon.getResponseCode();
			
			if (status == HttpURLConnection.HTTP_OK){
				//logger.info("status= " + status);
				System.out.println("status= " + status);
				server.setState(ServersStatusEnum.OK);
			}
			if (status != HttpURLConnection.HTTP_OK && status < 500 ) {
				//logger.info("status= " + status);
				System.out.println("status= " + status);
				server.setState(ServersStatusEnum.WARN);
			} 
			if (status >= 500){
				//logger.info("status= " + status);
				System.out.println("status= " + status);
				server.setState(ServersStatusEnum.FAIL);
			}
			
			//hostInfo.put("address", address.getHostAddress().toString());
			//hostInfo.put("response", urlCon.getResponseMessage());	
			server.setIpAddress(address.getHostAddress().toString());
			server.setResponse(urlCon.getResponseMessage());
			
			return server;
			
		} catch (Exception e) {
			System.out.println("Error connection: " + e.getMessage());
			//hostInfo.put("status", ServersStatusEnum.FAIL.name());
			server.setState(ServersStatusEnum.FAIL);
			return server;
		}
		
	}

}