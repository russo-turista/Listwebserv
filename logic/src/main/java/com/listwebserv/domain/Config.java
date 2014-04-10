package com.listwebserv.domain;

/**
 * @author fgm
 *
 */
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


	public int getIntUpdate() {
		return timeUpdate;
	}


	public void setIntUpdate(int intUpdate) {
		this.timeUpdate = intUpdate;
	}


	public String getAddersSMTP() {
		return addressSMTP;
	}


	public void setAddersSMTP(String addersSMTP) {
		this.addressSMTP = addersSMTP;
	}


	public int getPortSMTP() {
		return portSMTP;
	}


	public void setPortSMTP(int portSMTP) {
		this.portSMTP = portSMTP;
	}
	
}
