/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listwebserv.dao;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;

/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class ServersDAOImpl implements ServersDAO {

    
	@Autowired 
    private Servers servers;

    
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
    @Resource
    private JdbcOperations jdbcTemplate;
  
    private RowMapper<Servers> rowMapperServ = new RowMapper<Servers>() {

        public Servers mapRow(ResultSet rs, int rowNum) throws SQLException {
        	servers = new Servers();
        	servers.setHostName(rs.getString("hostName"));
        	servers.setIpAddress(rs.getString("ipAddress"));
            return servers;
        }
    };

	public void addServer(String hostName, String ipAdress) {
		sql = "INSERT INTO server(HOSTNAME, RESPONSEHOST, LASTCHECK, CREATED, ACTIVE, STATE, IPADDRESS) VALUES(?,?,?,?,?,?::state_type,?)";
        jdbcTemplate.update(sql, hostName, "good", new Date(), new Date(2014, 03,12), true, "OK", ipAdress);
	}
	
	
	public List<Servers> getListServ() {
		sql = "SELECT hostName, ipAddress from server";
		return jdbcTemplate.query(sql, rowMapperServ);
	}

	
}
