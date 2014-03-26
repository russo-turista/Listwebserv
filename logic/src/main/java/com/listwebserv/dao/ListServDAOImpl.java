/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listwebserv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Servers;

/**
 *
 * Реализация интрефейса {@link ListServDAO}
 */
@Repository
public class ListServDAOImpl implements ListServDAO {

    
    @Inject
    private Servers servers;
    
    private String sql = "";
    
    /**
     * переменная типа {@link JdbcTemplate} экземпляр класса
     * SimpleJdbcTemplate
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * Реализуем jdbcTemplate, передаем параметры соединения
     *
     * @param dataSource {@link DataSource}
     */
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Servers> rowMapperServ = new RowMapper<Servers>() {
    	
        public Servers mapRow(ResultSet rs, int rowNum) throws SQLException {
        	servers = new Servers();
        	servers.setHostName(rs.getString("hostName"));
        	servers.setHostInfo(rs.getString("hostInfo"));
            return servers;
        }
    };
    
	public void addUser(String user, String password) {
		// TODO Auto-generated method stub
		
	}

	
	public void addServerName(String hostName, String hostInfo) {
		sql = "insert into servList(hostName, hostInfo) values "
                + "(:hostName, :hostInfo);";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("hostName", hostName);
        parameters.put("hostInfo", hostInfo);

        jdbcTemplate.update(sql, parameters);
		
	}

	
	public List<Servers> getListServ() {
		sql = "SELECT hostName, hostInfo from servList";
		return jdbcTemplate.query(sql, rowMapperServ);
	}
	
}
