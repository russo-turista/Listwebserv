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
import com.listwebserv.service.enums.ServersStatusEnum;

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
        	servers.setIdServer(rs.getLong("idServer"));
        	servers.setHostName(rs.getString("hostName"));
        	servers.setHostPort(rs.getInt("hostPort"));
        	servers.setUrlPath(rs.getString("urlPath"));
        	servers.setLastCheck(rs.getTimestamp("lastCheck"));
        	servers.setCreated(rs.getTimestamp("created"));
        	servers.setActive(rs.getBoolean("active"));
        	servers.setState(ServersStatusEnum.valueOf(rs.getString("state")));
        	servers.setResponse(rs.getString("response"));
        	servers.setIpAddress(rs.getString("ipAddress"));
            return servers;
        }
    };

	public void setServerDB(Servers server) {
		sql = "INSERT INTO server(HOSTNAME, HOSTPORT, LASTCHECK, CREATED, ACTIVE, STATE, RESPONSE, IPADDRESS) VALUES(?,?,?,?,?,?::state_type,?,?)";
        jdbcTemplate.update(sql, 
	        					server.getHostName(), server.getHostPort(), 
	        					new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 
	        					server.getActive(), server.getState().name(), server.getResponse(), server.getIpAddress());
        /*sql = "INSERT INTO server(HOSTNAME, HOSTPORT, LASTCHECK, CREATED, ACTIVE, STATE, RESPONSE, IPADDRESS) values "
                + "(:hostName, :hostPort, :lastCheck, :created, :active, :state, :response, :ipAddress);";
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        parameters.put("hostName", server.getHostName());
        parameters.put("hostPort", server.getHostPort());
        parameters.put("lastCheck", new Timestamp(System.currentTimeMillis()));
        parameters.put("created", new Timestamp(System.currentTimeMillis()));
        parameters.put("active", server.getActive());
        parameters.put("state", server.getState().name());
        parameters.put("response", server.getResponse());
        parameters.put("ipAddress", server.getIpAddress());
        jdbcTemplate.update(sql, parameters);
        jdbcTemplate.up*/
        
	}
	
	
	public List<Servers> getListServDB() {
		sql = "SELECT * from server";
		return jdbcTemplate.query(sql, rowMapperServ);
	}

	
}
