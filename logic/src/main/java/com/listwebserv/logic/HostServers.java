package com.listwebserv.logic;

import org.springframework.stereotype.Component;
import java.net.*;

@Component
public class HostServers {
	public StringBuilder stringTableBuild = new StringBuilder();
	public String protocol = "HTTP";
	
	
	public String httpUrlServers(String hostName, Integer hostPort ) throws Exception {
		
		if (stringTableBuild.capacity() != 0) {
			stringTableBuild.delete(0, stringTableBuild.length());
		}
		URL url = new URL(protocol, hostName, hostPort,"/");		
		InetAddress address = InetAddress.getByName(url.getHost());		
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();

		stringTableBuild.append(address.getHostAddress().toString());
		stringTableBuild.append("  ");
		stringTableBuild.append(urlCon.getResponseMessage());	
		
		return stringTableBuild.toString();
	}

}