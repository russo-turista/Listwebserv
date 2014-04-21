package com.listwebserv.domain;

import org.springframework.stereotype.Component;

/**
 * @author fgm
 *
 */
@Component
public class Config {
	
	/**
	 * Интервал опроса серверов в секундах.

	 */
	private int timeRequest;

	/**
	 * Таймаут ожидания ответа сервера в секундах, 
		по истечении которого считается, что сервер не 
		вернул ответа.
	 */
	private int timeOutWaiting;
	
	/**
	 * Интервал обновления страницы на стороне 
		клиента (в секундах).
	 */
	private int timeUpdate;
	
	/**
	 * Адрес SMTP-сервера для отправки почтовых 
		сообщений.
	 */
	private String addressSMTP;
	
	
	/**
	 * Порт SMTP-сервера.
	 */
	private int portSMTP;

	/**
	 * 
	 * Влючен или выключен опрос серверов
	 */
	private boolean activeRuquest;
	
	public boolean getActiveRuquest() {
		return activeRuquest;
	}


	public void setActiveRuquest(boolean activeRuquest) {
		this.activeRuquest = activeRuquest;
	}


	public int getTimeRequest() {
		return timeRequest;
	}


	public void setTimeRequest(int timeRequest) {
		this.timeRequest = timeRequest;
	}


	public int getTimeOutWaiting() {
		return timeOutWaiting;
	}


	public void setTimeOutWaiting(int timeOutWaiting) {
		this.timeOutWaiting = timeOutWaiting;
	}


	public int getTimeUpdate() {
		return timeUpdate;
	}


	public void setTimeUpdate(int timeUpdate) {
		this.timeUpdate = timeUpdate;
	}


	public String getAddressSMTP() {
		return addressSMTP;
	}


	public void setAddressSMTP(String addressSMTP) {
		this.addressSMTP = addressSMTP;
	}


	public int getPortSMTP() {
		return portSMTP;
	}


	public void setPortSMTP(int portSMTP) {
		this.portSMTP = portSMTP;
	}
	
}
