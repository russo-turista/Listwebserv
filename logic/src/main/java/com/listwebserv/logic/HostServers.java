package com.listwebserv.logic;

import org.springframework.stereotype.Component;

import com.listwebserv.service.enums.ServersStatusEnum;

import java.net.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class HostServers {
	public StringBuilder stringTableBuild = new StringBuilder();
	public static final  String PROTOCOL = "HTTP";
	private Map <String, Object> hostInfo = new HashMap<String, Object>();
	
	public Map<String, Object> httpUrlServers(String hostName, Integer hostPort, Integer timeOutWaiting )  {
		
		
		try{
			
			URL url = new URL(PROTOCOL, hostName, hostPort,"/");
			InetAddress address = InetAddress.getByName(url.getHost());	
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(timeOutWaiting);
			
			int status = urlCon.getResponseCode();
			
			if (status == HttpURLConnection.HTTP_OK){
				hostInfo.put("status", ServersStatusEnum.OK.name());
			}
			if (status != HttpURLConnection.HTTP_OK || status <= 500 ) {
				hostInfo.put("status", ServersStatusEnum.WARN.name());
			} 
			if (status >= 500){
				hostInfo.put("status", ServersStatusEnum.FAIL.name());
			}
			
			hostInfo.put("address", address.getHostAddress().toString());
			hostInfo.put("response", urlCon.getResponseMessage());	
			
			return hostInfo;
			
		} catch (Exception e) {
			System.out.println("Error connection: " + e.getMessage());
			hostInfo.put("status", ServersStatusEnum.FAIL.name());
			return hostInfo;
		}
		
	}

}