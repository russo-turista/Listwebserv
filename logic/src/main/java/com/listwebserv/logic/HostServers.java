package com.listwebserv.logic;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;


public class HostServers {
	public StringBuilder stringTableBuld = new StringBuilder();
	public String protocol = "HTTP";
	
	/*public Map<String, String> getAddressIP(){
		return addressIP;
	}*/

	
	public String httpUrlServers(String hostName, String hostPortString ) throws IOException {
		int hostPort = Integer.parseInt(hostPortString);
		if (stringTableBuld.capacity() != 0) {
			stringTableBuld.delete(0, stringTableBuld.length());
		}
		URL url = new URL(protocol, hostName, hostPort,"/");
		
		InetAddress address = InetAddress.getByName(url.getHost());
		//address.getHostAddress()
		//addressIP = address.toString();
		//addressIP = address.getHostAddress().toString();
		//addressIP = addressIP.substring(addressIP.indexOf("/")+1,addressIP.length()); 
		
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();

		// Display request method.
		// System.out.println("Request method is " + hpCon.getRequestMethod());
		//requestServers.addressIP.put(hostName, address.getHostAddress().toString() + "  " + urlCon.getResponseMessage());
//		addressIP.put(hostName, address.getHostAddress().toString() + "  " + urlCon.getResponseMessage());
		/*stringTableBuld.append("Метод запроса: ");
		stringTableBuld.append(urlCon.getRequestMethod());
		stringTableBuld.append("<br>");
		

		stringTableBuld.append(" Код ответа: ");
		stringTableBuld.append(urlCon.getResponseCode());
		stringTableBuld.append("<br>");

		stringTableBuld.append(" Сообщение ответа: ");
		stringTableBuld.append(urlCon.getResponseMessage());
		stringTableBuld.append("<br>");*/
		
				
		// Get a list of the header fields and a set
		// of the header keys.
	//	Map<String, List<String>> hdrMap = urlCon.getHeaderFields();
		//Set<String> hdrField = hdrMap.keySet();

		

		// Display all header keys and values..
		/*for (String k : hdrField) {
			stringTableBuld.append(k + ": " + hdrMap.get(k));
			stringTableBuld.append("<br>");
		}*/

		stringTableBuld.append(address.getHostAddress().toString());
		stringTableBuld.append("  ");
		stringTableBuld.append(urlCon.getResponseMessage());
		
		
		return stringTableBuld.toString();
	}

}