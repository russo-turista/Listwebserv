/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listwebserv.dao;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;

/**
 *
 * Реализация интрефейса {@link ListServDAO}
 */
@Repository
public class ListServDAOImpl implements ListServDAO {

    
	@Autowired 
    private Servers servers;
	@Autowired
	private User user;
    
    private String sql = "";
    
    /**
     * переменная типа {@link JdbcTemplate} экземпляр класса
     * SimpleJdbcTemplate
     */
   // private JdbcTemplate jdbcTemplate;

    /**
     * Реализуем jdbcTemplate, передаем параметры соединения
     *
     * @param dataSource {@link DataSource}
     */
    //@Resource(name = "dataSource")
    @Resource
    private JdbcOperations jdbcTemplate;
    
    /*public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    private RowMapper<Servers> rowMapperServ = new RowMapper<Servers>() {

        public Servers mapRow(ResultSet rs, int rowNum) throws SQLException {
        	servers = new Servers();
        	servers.setHostName(rs.getString("hostName"));
        	servers.setIpAdress(rs.getString("ipAdress"));
            return servers;
        }
    };
    private RowMapper<User> rowMapperUser = new RowMapper<User>() {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	user = new User();
        	user.setName(rs.getString("name"));
        	user.setLogin(rs.getString("login"));
        	user.setAdmin(rs.getBoolean("admin"));
        	user.setActive(rs.getBoolean("active"));
        	user.setPassword(rs.getString("password"));
        	
            return user;
        }
    };


	public void addServerName(String hostName, String ipAdress) {
		/*sql = "insert into server(hostName, ipAdress) values "
                + "(:hostName, :ipAdress);";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("hostName", hostName);
        parameters.put("ipAdress", ipAdress);

        jdbcTemplate.update(sql, parameters);*/
		sql = "INSERT INTO server(HOSTNAME, RESPONSEHOST, LASTCHECK, CREATED, ACTIVE, STATE, IPADRESS) VALUES(?,?,?,?,?,?::state_type,?)";
        jdbcTemplate.update(sql, hostName, "good", new Date(), new Date(2014, 03,12), true, "OK", ipAdress);
	}
	
	public void addUser(String name, String login, String password, String email, Timestamp created, Timestamp lastLogin, boolean active, boolean admin){
		sql = "INSERT INTO users (NAME, LOGIN, PASSWORD, EMAIL, CREATED, LASTLOGIN, ACTIVE, ADMIN)VALUES(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,name, login, password, email, new Date(), new Date(), active, admin);		
	}

	
	public List<User> getListUser() {
		sql = "SELECT NAME, LOGIN, ADMIN from users";
		return jdbcTemplate.query(sql, rowMapperUser);
	}
	
	public List<Servers> getListServ() {
		sql = "SELECT hostName, ipAdress from server";
		return jdbcTemplate.query(sql, rowMapperServ);
	}
   
	
}
