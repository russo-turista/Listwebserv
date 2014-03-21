package com.listwebserv.domain;

import java.security.Timestamp;

import org.springframework.stereotype.Component;

/**
 * @author fgm
 *
 */
@Component
public class Servers {
	
	private Long Id;	
    private String hostName;
    private Integer hostPort;
    private String urlPath; 
    private String responseHost;
    private Timestamp lastCheck;
    private Timestamp created;
    private Boolean active;
    private Enum state;
    
    
    //private String ipAdress;
    private String hostInfo;
    
	public String getHostInfo() {
		return hostInfo;
	}
	/**
	 * @param hostInfo
	 */
	public void setHostInfo(String hostInfo) {
		this.hostInfo = hostInfo;
	}
	/*public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}*/
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
