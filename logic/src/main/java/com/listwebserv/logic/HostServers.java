package com.listwebserv.logic;

import org.springframework.stereotype.Component;

import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

@Component
public class HostServers {
	public StringBuilder stringTableBuld = new StringBuilder();
	public String protocol = "HTTP";
	
	
	public String httpUrlServers(String hostName, Integer hostPortString ) throws Exception {
		
		if (stringTableBuld.capacity() != 0) {
			stringTableBuld.delete(0, stringTableBuld.length());
		}
		URL url = new URL(protocol, hostName, hostPortString,"/");		
		InetAddress address = InetAddress.getByName(url.getHost());		
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();

		stringTableBuld.append(address.getHostAddress().toString());
		stringTableBuld.append("  ");
		stringTableBuld.append(urlCon.getResponseMessage());	
		
		return stringTableBuld.toString();
	}

}