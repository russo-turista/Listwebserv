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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
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
            return servers;
        }
    };
    
	public void addUser(String user, String password) {
		// TODO Auto-generated method stub
		
	}

	
	public void addServerName(String hostName) {
		/*sql = "insert into servList(hostName) values "
                + "(:hostName)";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("hostName", hostName);

        jdbcTemplate.update(sql, parameters);*/
        jdbcTemplate.update("INSERT INTO servList(hostName) VALUES(?)", hostName);
	}

	
	public List<Servers> getListServ() {
		sql = "SELECT hostName from servList";
		return jdbcTemplate.query(sql, rowMapperServ);
	}
	
}
