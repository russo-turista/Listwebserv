/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listwebserv.dao;


import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Config;


/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class SettingsDAOImpl implements  SettingsDAO{

	
	@Autowired
	private Config config;
    
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

    private RowMapper<Config> rowMapperConfig = new RowMapper<Config>() {

        public Config mapRow(ResultSet rs, int rowNum) throws SQLException {
        	config = new Config();
        	config.setTimeRequest(rs.getInt("timeRequest"));
        	config.setTimeOutWaiting(rs.getInt("timeOutWaiting"));
        	config.setTimeUpdate(rs.getInt("timeUpdate"));
        	config.setPortSMTP(rs.getInt("portSMTP"));
        	config.setAddressSMTP(rs.getString("addressSMTP"));
        	config.setActiveRuquest(rs.getBoolean("activeRuquest"));
        
            return config;
        }
    };

	@Override
	public void setConfigDB(Config config) {
		sql = "UPDATE  config SET timeRequest = ?, timeOutWaiting = ?, "
				+ "timeUpdate = ?, portSMTP = ?, addressSMTP = ?, activeRuquest = ?";
		
		Object[] parameters = {config.getTimeRequest(), config.getTimeOutWaiting(),
				 			   config.getTimeUpdate(), config.getPortSMTP(),
				 			   config.getAddressSMTP(), config.getActiveRuquest()};

	        jdbcTemplate.update(sql, parameters);
	}

	@Override
	public Config getConfigDB() {
		sql = "SELECT * FROM config";
		return jdbcTemplate.queryForObject(sql, rowMapperConfig);
	}
	
}
