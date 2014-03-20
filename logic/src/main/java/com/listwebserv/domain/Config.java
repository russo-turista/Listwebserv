package com.listwebserv.domain;

/**
 * @author fgm
 *
 */
public class Config {
	
	/**
	 * Интервал опроса серверов в секундах.

	 */
	private int iterRequest;
	
	
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
	private int intUpdate;
	
	/**
	 * Адрес SMTP-сервера для отправки почтовых 
		сообщений.
	 */
	private String addersSMTP;
	
	
	/**
	 * Порт SMTP-сервера.
	 */
	private int portSMTP;


	public int getIterRequest() {
		return iterRequest;
	}


	public void setIterRequest(int iterRequest) {
		this.iterRequest = iterRequest;
	}


	public int getTimeOutWaiting() {
		return timeOutWaiting;
	}


	public void setTimeOutWaiting(int timeOutWaiting) {
		this.timeOutWaiting = timeOutWaiting;
	}


	public int getIntUpdate() {
		return intUpdate;
	}


	public void setIntUpdate(int intUpdate) {
		this.intUpdate = intUpdate;
	}


	public String getAddersSMTP() {
		return addersSMTP;
	}


	public void setAddersSMTP(String addersSMTP) {
		this.addersSMTP = addersSMTP;
	}


	public int getPortSMTP() {
		return portSMTP;
	}


	public void setPortSMTP(int portSMTP) {
		this.portSMTP = portSMTP;
	}
	
}
