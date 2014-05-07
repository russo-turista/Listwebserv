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
import com.listwebserv.domain.User;
import com.listwebserv.service.enums.ServersStatusEnum;

/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class ServersDAOImpl implements ServersDAO {

    
	@Autowired 
    private Server server;
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
    @Resource
    private JdbcOperations jdbcTemplate;
  
    private RowMapper<Server> rowMapperServ = new RowMapper<Server>() {

        public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
        	server = new Server();
        	server.setIdServer(rs.getLong("idServer"));
        	server.setHostName(rs.getString("hostName"));
        	server.setHostPort(rs.getInt("hostPort"));
        	server.setUrlPath(rs.getString("urlPath"));
        	server.setLastCheck(rs.getTimestamp("lastCheck"));
        	server.setCreated(rs.getTimestamp("created"));
        	server.setActive(rs.getBoolean("active"));
        	server.setState(ServersStatusEnum.valueOf(rs.getString("state")));
        	server.setResponse(rs.getString("response"));
        	server.setIpAddress(rs.getString("ipAddress"));
            return server;
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
	public void setServerToUsersDB(Long idServer, Long idUser) {
		sql = "INSERT INTO userlists(idServer, idUser) VALUES(?,?)";
		jdbcTemplate.update(sql,idServer, idUser);
	}


	@Override
	public void setMapIdServersDB(Map<Integer, String> mapServers) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Server> getServersToUserDB(Long idUser) {
		sql = "SELECT * FROM server WHERE server.idserver in"
				+ "(SELECT userlists.idserver FROM userlists WHERE  idUser = ?) ORDER BY server.state desc";
		
		return jdbcTemplate.query(sql, rowMapperServ, idUser);
	}

	@Override
	public Server getIdServerDB(Long idServer) {
		sql = "SELECT * FROM server WHERE idServer = ?";
		return jdbcTemplate.queryForObject(sql, rowMapperServ, idServer);
	}


	@Override
	public void setEditServerDB(Server server) {
		sql = "UPDATE  server SET hostName = ?, hostPort = ?, lastCheck = ?, "
				+ "ACTIVE = ?, STATE = ?::state_type, RESPONSE = ?, "
				+ "IPADDRESS = ? WHERE idServer = ?";
		
		Object[] parameters = {
				server.getHostName(), server.getHostPort(), 
				new Timestamp(System.currentTimeMillis()), 
				server.getActive(), server.getState().name(), 
				server.getResponse(), server.getIpAddress(), server.getIdServer()};

	   jdbcTemplate.update(sql, parameters);
		
	}

	
}
