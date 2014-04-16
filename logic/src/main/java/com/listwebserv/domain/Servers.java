package com.listwebserv.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.listwebserv.service.enums.ServersStatusEnum;

/**
 * @author fgm
 *
 */
@Component
public class Servers {
	
	/**
	 * Уникальный идентификатор сущности в системе.
	 */
	private Long idServer;	
	
    /**
     * Уникальное имя сервера в системе.
     */
    private String hostName;
    
    /**
     * Порт сервера.
     */
    private Integer hostPort;
    
    /**
     * Путь к ресурсу. 
     */
    private String urlPath; 
    
    /**
     * Заголовки последнего ответа сервера.
     */
    private String response;
    
    /**
     * Время последней проверки состояния.
     */
    private Timestamp lastCheck;
    
    /**
     * Дата создания или редактирования.
     */
    private Timestamp created;
    
    /**
     * В случае значения false для сущности не нужно выполнять мониторинг состояния.
     */
    private Boolean active;
    
    /**
     * Последнее состояние.
     */
    private ServersStatusEnum state; 
    
    /**
     * IP-адрес или имя хоста.
     */
    private String ipAddress;
    
    
    public Long getIdServer() {
		return idServer;
	}
	public void setIdServer(Long idServer) {
		this.idServer = idServer;
	}
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Timestamp getLastCheck() {
		return lastCheck;
	}
	public void setLastCheck(Timestamp lastCheck) {
		this.lastCheck = lastCheck;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public ServersStatusEnum getState() {
		return state;
	}
	public void setState(ServersStatusEnum state) {
		this.state = state;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
    
	/**
	 * @return
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return
	 */
	public String getHostName() {
		return hostName;
	}
	/**
	 * @param hostName
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	/**
	 * @return
	 */
	public Integer getHostPort() {
		return hostPort;
	}
	/**
	 * @param hostPort
	 */
	public void setHostPort(Integer hostPort) {
		this.hostPort = hostPort;
	}
	
	
    
  
 
 
}
