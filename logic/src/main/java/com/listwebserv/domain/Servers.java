package com.listwebserv.domain;

import org.springframework.stereotype.Component;

@Component
public class Servers {
	
    private String hostName;
    private Integer hostPort;
    private String ipAdress;
    private String state;
    private String hostInfo;
    
	public String getHostInfo() {
		return hostInfo;
	}
	public void setHostInfo(String hostInfo) {
		this.hostInfo = hostInfo;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Integer getHostPort() {
		return hostPort;
	}
	public void setHostPort(Integer hostPort) {
		this.hostPort = hostPort;
	}
	
	
    
  
 
 
}
