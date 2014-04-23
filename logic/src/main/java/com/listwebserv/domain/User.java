package com.listwebserv.domain;

import java.security.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author fgm
 * Класс сущности User
 */
@Component
public class User {
	
	/**
	 *  Уникальный идентификатор сущности в системе
	 */
	private Long userId; 
	
	/**
	 * ФИО сотрудника.
	 */
	private String name;
	
	/**
	 * Уникальное имя для входа в систему.
	 */
	private String login;
	
	/**
	 * Хэш пароля пользователя
	 */
	private String password;
	
	/**
	 * Адрес электронной почты для отправки уведомлений 
	 */
	private String email;
	
	/**
	 * Дата создания
	 */
	private Timestamp created;
	
	/**
	 * Дата последнего входа в систему.
	 */
	private Timestamp lastLogin;
	
	
	/**
	 * Сотрудники, у которых данное поле установлено в значение 
		false, не должны иметь возможности авторизоваться в 
		системе
	 */
	private Boolean active;
	
	
	/**
	 * Признак того, является ли сотрудник Администратором.
	 */
	private Boolean admin;
	
	/**
	 * Список пользователей
	 * 
	 */
	private List<User> listUsers;
	public List<User> getListUsers() {
		return listUsers;
	}


	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Timestamp getCreated() {
		return created;
	}


	public void setCreated(Timestamp created) {
		this.created = created;
	}


	public Timestamp getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
