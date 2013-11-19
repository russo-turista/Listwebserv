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

@Component
public class HostServers {
	@Inject 
	private RequestServers requestServers;
	public StringBuilder stringTableBuld = new StringBuilder();
	public String protocol = "HTTP";
	//public Map<String, String> addressIP = new HashMap<String, String>();
	
	/*public String getServersName(String hostName)
			throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println(Address);
		Address = InetAddress.getByName(hostName);
		System.out.println(Address);
		InetAddress SW[] = InetAddress.getAllByName(hostName);
		
		 // for (int i = 0; i < SW.length; i++) System.out.println(SW[i]);
		 
		return addressIP;
	}*/
	/*public Map<String, String> getAddressIP(){
		return addressIP;
	}*/

	/*
	 * Добавим соединения Socket
	 */
	public String createScketConnect(String hostName, String hostPortString) {

		int c;
		int hostPort = Integer.parseInt(hostPortString);
		// Create a socket connected.
		try (Socket s = new Socket(hostName, hostPort)) {

			// Obtain input and output streams.
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();

			// Construct a request string.
			// String str = (args.length == 0 ? "MHProfessional.com" : args[0])
			// + "\n";
			String str = (hostName +":" + hostPort + "/");
			// Convert to bytes.
			byte buf[] = str.getBytes();

			// Send request.
			out.write(buf);

			// Read and display response.
			while ((c = in.read()) != -1) {
				stringTableBuld.append((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringTableBuld.toString();
	}

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
		requestServers.addressIP.put(hostName, address.getHostAddress().toString() + "  " + urlCon.getResponseMessage());
//		addressIP.put(hostName, address.getHostAddress().toString() + "  " + urlCon.getResponseMessage());
		stringTableBuld.append("Метод запроса: ");
		stringTableBuld.append(urlCon.getRequestMethod());
		stringTableBuld.append("<br>");
		

		stringTableBuld.append(" Код ответа: ");
		stringTableBuld.append(urlCon.getResponseCode());
		stringTableBuld.append("<br>");

		stringTableBuld.append(" Сообщение ответа: ");
		stringTableBuld.append(urlCon.getResponseMessage());
		stringTableBuld.append("<br>");
		
				
		// Get a list of the header fields and a set
		// of the header keys.
		Map<String, List<String>> hdrMap = urlCon.getHeaderFields();
		Set<String> hdrField = hdrMap.keySet();

		

		// Display all header keys and values..
		/*for (String k : hdrField) {
			stringTableBuld.append(k + ": " + hdrMap.get(k));
			stringTableBuld.append("<br>");
		}*/

		
		
		return stringTableBuld.toString();
	}

}