package com.listwebserv.domain;

import org.springframework.stereotype.Component;

@Component
public class Servers {
    private String hostName;
    private Integer hostPort;
    
    
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
