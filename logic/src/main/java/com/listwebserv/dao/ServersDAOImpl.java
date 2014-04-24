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

import com.listwebserv.domain.Server;
import com.listwebserv.service.enums.ServersStatusEnum;

/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class ServersDAOImpl implements ServersDAO {

    
	@Autowired 
    private Server servers;

    
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
  
    private RowMapper<Server> rowMapperServ = new RowMapper<Server>() {

        public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
        	servers = new Server();
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

	public void setServerDB(Server server) {
		sql = "INSERT INTO server(HOSTNAME, HOSTPORT, LASTCHECK, CREATED, ACTIVE, STATE, RESPONSE, IPADDRESS) VALUES(?,?,?,?,?,?::state_type,?,?)";
        jdbcTemplate.update(sql, 
        		server.getHostName(), server.getHostPort(),
				new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), server.getActive(),
				server.getState().name(), server.getResponse(),
				server.getIpAddress());
	}
	
	
	public List<Server> getListServDB() {
		sql = "SELECT * from server";
		return jdbcTemplate.query(sql, rowMapperServ);
	}


	@Override
	public void updateSeverDB(Server server) {
		sql = "UPDATE  server SET HOSTPORT = ?, LASTCHECK = ?, "
				+ "CREATED = ?, ACTIVE = ?, STATE = ?::state_type, RESPONSE = ?, "
				+ "IPADDRESS = ? WHERE HOSTNAME = ?";
		
		Object[] parameters = {
				server.getHostPort(), 
				new Timestamp(System.currentTimeMillis()), server.getCreated(), 
				server.getActive(), server.getState().name(), 
				server.getResponse(), server.getIpAddress(), server.getHostName()};

	   jdbcTemplate.update(sql, parameters);	
	}


	@Override
	public Map<String, Object> getmapIdServersDB() {
		sql = "SELECT idServer, hostName from server";
		return jdbcTemplate.queryForMap(sql);
	}


	@Override
	public void setmapIdServersDB(Map<Integer, String> mapServers) {
		// TODO Auto-generated method stub
		
	}

	
}
